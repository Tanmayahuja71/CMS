package JDBC;

public class SqlQuery {
	static String addStockQuery = "INSERT INTO Stock (PRODUCT_ID,PRODUCT_NAME,QTY,M_UNIT,MRP,DISCOUNT,TOTAL_STOCK) VALUES (?,?,?,?,?,?,?)";
	static String deleteQuery = "DELETE FROME stock WHERE id=?";
	static String addEmpDetailsQuery = "INSERT INTO Employees(ID,First_Name,Last_Name,Phone_No,Email_Id,Password) VALUES (?,?,?,?,?,?)";
	static String fetchPassQuery = "SELECT Password FROM Employees" +" WHERE id = (?)";
	static String deleteEmpAccountQuery = "DELETE FROM Employees" +" WHERE id = (?)";
	static String deleteIteamQuery = "DELETE FROM Stock" +" WHERE PRODUCT_ID = (?)";
	static String modifyPriceQuery = "UPDATE Stock SET MRP = (?) WHERE PRODUCT_NAME = (?)";
	static String modifyDiscountQuery = "UPDATE Stock "+"SET DISCOUNT = (?)"+" WHERE PRODUCT_NAME = (?)";
	static String fetchTotalStockQuery = "SELECT TOTAL_STOCK FROM Stock" +" WHERE PRODUCT_NAME = (?)";
	static String fetchMRPQuery = "SELECT MRP FROM Stock" +" WHERE PRODUCT_NAME = (?)";
	static String fetchDiscountQuery = "SELECT DISCOUNT FROM Stock" +" WHERE PRODUCT_NAME = (?)";
	static String addToatlStockQuery = "UPDATE Stock SET TOTAL_STOCK = TOTAL_STOCK+(?) WHERE PRODUCT_NAME = (?)";
	static String fetchTodayDataQuery = "SELECT SUM(TOTAL_AMOUNT),SUM(TOTAL_DISCOUNT),SUM(AMOUNT_AFTER_DISCOUNT) FROM customer WHERE DATE_OF_PURCHASE = CURRENT_DATE";
	static String fetchWeekDataQuery = "SELECT SUM(TOTAL_AMOUNT),SUM(TOTAL_DISCOUNT),SUM(AMOUNT_AFTER_DISCOUNT) FROM customer WHERE DATE_OF_PURCHASE>=DATE_SUB(CURRENT_DATE,INTERVAL 1 WEEK)";
	static String fetchHalfYearDataQuery = "SELECT SUM(TOTAL_AMOUNT),SUM(TOTAL_DISCOUNT),SUM(AMOUNT_AFTER_DISCOUNT) FROM customer WHERE DATE_OF_PURCHASE>=DATE_SUB(CURRENT_DATE,INTERVAL 6 MONTH)";
	static String fetchYearDataQuery = "SELECT SUM(TOTAL_AMOUNT),SUM(TOTAL_DISCOUNT),SUM(AMOUNT_AFTER_DISCOUNT) FROM customer WHERE DATE_OF_PURCHASE>=DATE_SUB(CURRENT_DATE,INTERVAL 1 YEAR)";
	static String fetchProductDetailsQuery="SELECT * FROM stock WHERE PRODUCT_NAME=(?)";
}