import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class crud2 {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "mouni";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MySQL Table Manager ===");
            System.out.println("1. Create Tables");
            System.out.println("2. Insert Data");
            System.out.println("3. Drop Tables");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }

            String createFile = "creatingfile.txt";
            String insertFile = "insertingvalues.txt";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try (
                    Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
                    Statement stmt = conn.createStatement()
                ) {
                    switch (choice) {
                        case 1:
                            System.out.println("\nCreating tables from: " + createFile);
                            processSqlFile(createFile, stmt, true);
                            break;
                        case 2:
                            System.out.println("\nInserting data from: " + insertFile);
                            processSqlFile(insertFile, stmt, false);
                            break;
                        case 3:
                            List<String> tablesToDrop = extractTableNames(createFile);
                            for (String table : tablesToDrop) {
                                String dropSql = "DROP TABLE IF EXISTS " + table + " CASCADE";
                                try {
                                    stmt.executeUpdate(dropSql);
                                    System.out.println("❌ Dropped table: " + table);
                                } catch (SQLException e) {
                                    System.out.println("Error dropping table " + table + ": " + e.getMessage());
                                }
                            }
                            break;
                        default:
                            System.out.println("❗ Invalid choice.");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    private static void processSqlFile(String fileName, Statement stmt, boolean isCreate) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sqlBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line).append("\n");
            }

            String[] sqlStatements = sqlBuilder.toString().split(";");

            for (String sql : sqlStatements) {
                sql = sql.trim();
                if (!sql.isEmpty() && !sql.startsWith("--")) { // skip SQL comments
                    try {
                        if (isCreate) {
                            stmt.execute(sql);
                            if (sql.toUpperCase().startsWith("CREATE TABLE")) {
                                System.out.println("✅ Created table: " + getTableName(sql));
                            }
                        } else {
                            if (sql.toUpperCase().startsWith("INSERT INTO")) {
                                stmt.executeUpdate(sql);
                                System.out.println("✔ Inserted values: " + getTableName(sql));
                            } else if (sql.toUpperCase().startsWith("DELETE FROM")) {
                                String table = getTableName(sql);
                                if (tableExists(stmt.getConnection(), table)) {
                                    stmt.executeUpdate(sql);
                                    System.out.println("🧹 Cleared values: " + table);
                                } else {
                                    System.out.println("⚠ Table does not exist (skipped DELETE): " + table);
                                }
                            } else {
                                stmt.execute(sql); // other statements
                            }
                        }
                    } catch (SQLException e) {
                        System.out.println("SQL Error: " + sql);
                        throw e;
                    }
                }
            }

        } catch (IOException | SQLException e) {
            System.out.println("❗ Error in file " + fileName + ": " + e.getMessage());
        }
    }

    private static String getTableName(String sql) {
        Pattern pattern = Pattern.compile(
            "\\b(?:CREATE\\s+TABLE|INSERT\\s+INTO|DELETE\\s+FROM|DROP\\s+TABLE)\\s+(?:IF\\s+NOT\\s+EXISTS\\s+)?(\\w+)",
            Pattern.CASE_INSENSITIVE
        );
        Matcher matcher = pattern.matcher(sql);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "[unknown]";
    }

    private static boolean tableExists(Connection conn, String tableName) {
        try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName.toUpperCase(), null)) {
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    private static List<String> extractTableNames(String fileName) {
        List<String> tables = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder sqlBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line).append("\n");
            }
            String[] statements = sqlBuilder.toString().split(";");
            for (String sql : statements) {
                sql = sql.trim();
                if (sql.toUpperCase().startsWith("CREATE TABLE")) {
                    String table = getTableName(sql);
                    if (!table.equals("[unknown]")) {
                        tables.add(table);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("❗ Error reading for table names: " + e.getMessage());
        }
        return tables;
    }
}
