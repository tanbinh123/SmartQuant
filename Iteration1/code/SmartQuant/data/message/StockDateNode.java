package message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;
import javax.xml.soap.Node;

import enums.SortType;

/*
 * @author: xuan
 * @date: 2016/03/02
 * 
 * @mender: none
 * @date: none
 * 
 * @type: class
 * @description: 描述股票每天的具体信息
 */




public class StockDateNode implements NodeService,Comparable<StockDateNode>{

	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	private double[]typeNumber;

	private double volume;//成交量
	private double pb;//市净率
	private double high;//最高价
	private double adj_price;//后复权价
	private double low;//最低价
	private String date;//日期，日期的格式为2014-10-13，未限定日期格式
	private double close;//收盘价
	private double open;//开盘价
	private double turnover;//换手率 


	public String toString(){
		return "open: " + open + " high: " + high + " close: " + close; 
	}




	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getTurnover() {
		return turnover;
	}
	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}
	public double getAdj_price() {
		return adj_price;
	}
	public void setAdj_price(double adj_price) {
		this.adj_price = adj_price;
	}
	public double getPb() {
		return pb;
	}
	public void setPb(double pb) {
		this.pb = pb;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public int compareTo(StockDateNode o) {
		// TODO Auto-generated method stub
		Date thisDate = null;
		Date otherDate = null;
		try {
			thisDate = SDF.parse(this.date);
			otherDate = SDF.parse(o.date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(thisDate.before(otherDate))
			return -1;
		else if(thisDate.after(otherDate))
			return 1;
		else return 0;
	}




	@Override
	public double getType(SortType sortType) {
		// TODO Auto-generated method stub
		if(typeNumber == null){
			typeNumber = new double[] {volume,pb,high,adj_price,low,0,close,open,turnover};
		}
		return typeNumber[sortType.ordinal()];
	}
	
}
