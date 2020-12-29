package client.status;
import vcampus.vo.*;
import java.awt.EventQueue;
import vcampus.server.biz.*;
import vcampus.server.dao.*;
import vcampus.server.exception.*;
//import vcampus.util.*;
public class StatusCtl {

	public StatusCtl(String UserID,int UserType) {
		if(UserType==0) {
			StatusTVisit ST=new StatusTVisit(UserID,0);
			ST.setVisible(true);
		}
		else if(UserType==1) {
			StatusSVisit SV=new StatusSVisit(UserID,1);
			SV.setVisible(true);
		}
		else if(UserType==2) {
			TeaPosition TP=new TeaPosition(UserID,2);
			TP.setVisible(true);
		}
	}
	public static void main(String[] args) {
		///////////////////////////////////////////
		StatusCtl SC=new StatusCtl("1000",0);
		///////////////////////////////////////////
	}
}
