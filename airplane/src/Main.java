import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;




public class Main {
	Connection conn;

	int WIDTH=500;
	int HEIGHT=865;
	int A1_HEIGHT=400;
	int A4_HEIGHT=550;
	int flight_key =3;
	int seat_C=0;
	String start,end;

	String starting_Point,destination_Point,date,price,head_Count,time,user_Id;
	String[] head_Box= {"1","2","3","4","5"};
	String[] reserve_id =new String[50];
	String now_Id,now_Password,new_Password;
	int reserve_count=0;
	JFrame frame;
	ImageIcon start_image, search_AirPlaen_Image,select_Start_Area_Image, 
	select_End_Area_Image,back_Image,back2_Image,sign_Up_Image,air_Ticket_Image,login_Image,airplan_Image,korea_Image,
	germany_Image,russia_Image,usa_Image,japan_Image,singapore_Image,france_Image,menu_Image;
	JLabel sign_Up_Label,login_Label,user_Name_Label,user_Age_Label,user_Id_Label,user_Password_Label;
	JLabel user_Id_Label2,user_Password_Label2,login_Label2;
	JLabel user_Id_Label3,user_Password_Label3,new_Password_Label;
	JTextField user_Name_Field,user_Age_Field,user_Id_Field,user_Password_Field;
	JTextField user_Id_Field2;
	JTextField Password_Field ,Id_Field, newPassword_Field;
	JPasswordField user_Password_Field2;
	JLabel sign_Up_Label2,overlap_Id_Label,login_check_Label,country_Label,country_Label2,start_Date_Label;
	JLabel[] week;

	StartPanel start_Panel;
	//SearchAirPlanePanel search_AirPlane_Panel;
	SelectAreaPanel select_Start_Area_Panel;
	SelectAreaPanel select_End_Area_Panel;
	//SelectEndAreaPanel select_End_Area_Panel;
	Sign_Up_Panel sign_Up_Panel;
	CardLayout card;

	JButton start_Point_Button,destination_Point_Button,date_Button,search_Button;
	JComboBox head_Count_Box ,reserve_Box;
	JLabel start_Point_Label,destination_Point_Label,date_Label,airplane_title_Label,head_Count_Label;

	JButton doChange_Buttone;
	JButton back_A13;
	JButton changePassword;
	JButton delete_Reserve;
	JButton bMypage;
	JButton bPrint;
	JButton bPreview;
	JButton [] test;
	JButton sign_Up_Button,login_Button,login_Check_Button;
	JButton[] date_Sellect_Button ;
	JButton plane_Reserve_Button,back_Start_Button ;
	JButton start_Area_Button,end_Area_Button,back_Search_Button,sign_Up_finish_Button;
	JButton start_Korea,start_Germany,start_Russia,start_Usa,start_Japan,start_Singapore,start_France;
	JButton end_Korea,end_Germany,end_Russia,end_Usa,end_Japan,end_Singapore,end_France;
	JButton back_a4_Button,back_a4_Button2;
	JPanel start_County_Panel,end_Country_Panel,start_Chinese,start_Asia,start_AmericasEurope;
	JPanel mainPanel ,sign_up_frame_Panel,login_Panel;
	ChangePasswordPanel changePassword_Panel;
	JPanel adminPanel;
	JPanel datePanel;
	SearchAirPlanePanel airplanePanel;
	DatePanel date_Frame_Panel;
	FlightSelectPanel flight_Select_Panel;
	FlightsPanel flight_Panel;
	ConfirmFlightPanel confirm_Flight_Panel;
	SeatSelectPanel seat_Select_Panel;
	SeatPanel seat_Panel;
	FinalConfirmFlightPanel final_Confirm_Flight_Panel;
	ConfimPanel confim_Panel;
	Scrollbar bar1;
	JScrollPane scroll1,scroll2;
	FunctionPanel function_Panel;
	ArrayList<FlightMakePanel> list = new ArrayList<FlightMakePanel>();
	ArrayList<String> list_seat = new ArrayList<String>();
	ArrayList<String> list_seat_n = new ArrayList<String>();
	JButton[] seats ;
	boolean[] seat_Check=new boolean[41];


	public void go(){

		reserve_Box =new JComboBox();
		reserve_Box.setBounds(110,170,250,50);
		reserve_Box.setOpaque(false);
		bar1= new Scrollbar(Scrollbar.VERTICAL,0,750,500,750);
		bar1.setBounds(500, 0, 12, 500);

		date_Sellect_Button =new JButton[43];
		week=new JLabel[7];
		menu_Image =new ImageIcon("src/메뉴.png");
		back_Image= new ImageIcon("src/뒤로.png");
		back2_Image = new ImageIcon("src/뒤로2.png");
		start_image= new ImageIcon("src/비행기.png");
		search_AirPlaen_Image = new ImageIcon("src/항공권 검색.png");
		select_Start_Area_Image =new ImageIcon("src/출발지.png");
		select_End_Area_Image =new ImageIcon("src/도착지.png");
		sign_Up_Image = new ImageIcon("src/회원가입.png");
		air_Ticket_Image =new ImageIcon("src/항공예매.png");
		login_Image = new ImageIcon("src/로그인.png");
		airplan_Image = new ImageIcon("src/출도.jpg");
		korea_Image = new ImageIcon("src/한국.png");
		germany_Image= new ImageIcon("src/독일.png");
		russia_Image= new ImageIcon("src/러시아.png");
		usa_Image= new ImageIcon("src/미국.png");
		japan_Image= new ImageIcon("src/일본.png");
		singapore_Image= new ImageIcon("src/싱가포르.png");
		france_Image= new ImageIcon("src/프랑스.png");
		sign_Up_Label=new JLabel("회원가입");
		sign_Up_Label2 = new JLabel("회원가입");
		sign_Up_Label.setBounds(166, 270, 70, 70);
		login_Label = new JLabel("로그인");
		login_Label.setBounds(262, 270, 70, 70);

		overlap_Id_Label=new JLabel("");
		overlap_Id_Label.setBounds(200,80,150,20);
		login_check_Label = new JLabel();
		login_check_Label.setBounds(130,150,300,20);
		overlap_Id_Label.setForeground(Color.red);
		login_check_Label.setForeground(Color.red);
		sign_Up_Label2.setFont(new Font("굴림",Font.BOLD,30));
		sign_Up_Label2.setBounds(180,0,150,100);
		login_Label2=new JLabel("로그인");
		login_Label2.setFont(new Font("굴림",Font.BOLD,30));
		login_Label2.setBounds(200,0,150,100);



		end_Korea=new JButton();
		end_Korea.setIcon(korea_Image);
		end_Germany=new JButton();
		end_Germany.setIcon(germany_Image);
		end_Russia=new JButton();
		end_Russia.setIcon(russia_Image);
		end_Usa=new JButton();
		end_Usa.setIcon(usa_Image);
		end_Japan=new JButton();
		end_Japan.setIcon(japan_Image);
		end_Singapore=new JButton();
		end_Singapore.setIcon(singapore_Image);
		end_France=new JButton();
		end_France.setIcon(france_Image);

		end_Korea.addActionListener(new SelectEndActionListener());
		end_Germany.addActionListener(new SelectEndActionListener());
		end_Russia.addActionListener(new SelectEndActionListener());
		end_Usa.addActionListener(new SelectEndActionListener());
		end_Japan.addActionListener(new SelectEndActionListener());
		end_Singapore.addActionListener(new SelectEndActionListener());
		end_France.addActionListener(new SelectEndActionListener());

		end_Korea.setBackground(Color.white);
		end_Germany.setBackground(Color.white);
		end_Russia.setBackground(Color.white);
		end_Usa.setBackground(Color.white);
		end_Japan.setBackground(Color.white);
		end_Singapore.setBackground(Color.white);
		end_France.setBackground(Color.white);

		start_Korea=new JButton();
		start_Korea.setIcon(korea_Image);
		start_Germany=new JButton();
		start_Germany.setIcon(germany_Image);
		start_Russia=new JButton();
		start_Russia.setIcon(russia_Image);
		start_Usa=new JButton();
		start_Usa.setIcon(usa_Image);
		start_Japan=new JButton();
		start_Japan.setIcon(japan_Image);
		start_Singapore=new JButton();
		start_Singapore.setIcon(singapore_Image);
		start_France=new JButton();
		start_France.setIcon(france_Image);

		start_Korea.addActionListener(new SelectStartActionListener());
		start_Germany.addActionListener(new SelectStartActionListener());
		start_Russia.addActionListener(new SelectStartActionListener());
		start_Usa.addActionListener(new SelectStartActionListener());
		start_Japan.addActionListener(new SelectStartActionListener());
		start_Singapore.addActionListener(new SelectStartActionListener());
		start_France.addActionListener(new SelectStartActionListener());

		start_Korea.setBackground(Color.white);
		start_Germany.setBackground(Color.white);
		start_Russia.setBackground(Color.white);
		start_Usa.setBackground(Color.white);
		start_Japan.setBackground(Color.white);
		start_Singapore.setBackground(Color.white);
		start_France.setBackground(Color.white);



		for(int i=1;i<=31;i++) {
			date_Sellect_Button[i]=new JButton(""+i);
			date_Sellect_Button[i].addActionListener(new SelectDateActionListener());


		}


		date_Sellect_Button[32]=new JButton("");
		date_Sellect_Button[33]=new JButton("");
		date_Sellect_Button[34]=new JButton("");
		date_Sellect_Button[35]=new JButton("");
		date_Sellect_Button[36]=new JButton("");

		date_Sellect_Button[37]=new JButton("");
		date_Sellect_Button[38]=new JButton("");
		date_Sellect_Button[39]=new JButton("");
		date_Sellect_Button[40]=new JButton("");
		date_Sellect_Button[41]=new JButton("");
		date_Sellect_Button[42]=new JButton("");
		week[0]=new JLabel("         월");
		week[1]=new JLabel("         화");
		week[2]=new JLabel("         수");
		week[3]=new JLabel("         목 ");
		week[4]=new JLabel("         금 ");
		week[5]=new JLabel("         토 ");
		week[6]=new JLabel("         일 ");


		changePassword=new JButton("비밀번호 변경");
		changePassword.setBounds(155,370,150,50);
		changePassword.addActionListener(new ChangePanelListener());
		changePassword.setBackground(Color.white);



		doChange_Buttone=new JButton("변경");
		doChange_Buttone.setBounds(155,370,150,50);
		doChange_Buttone.addActionListener(new ChangePanelListener());
		doChange_Buttone.setBackground(Color.white);

		delete_Reserve=new JButton("취소");
		delete_Reserve.setBounds(375,170,70,50);
		delete_Reserve.addActionListener(new DeleteReserveActionListener());
		delete_Reserve.setBackground(Color.white);
		bPrint=new JButton("프린트");
		bPrint.setBounds(250,230,200,50);;
		bPrint.addActionListener(new DisplayButtonListener());
		bPrint.setBackground(Color.white);

		bPreview=new JButton("미리보기");
		bPreview.setBounds(250,300,200,50);
		bPreview.addActionListener(new DisplayButtonListener());
		bPreview.setBackground(Color.white);


		bMypage=new JButton("미리보기");
		bMypage.setBackground(new Color(54,138,255));
		bMypage.setBounds(5,10,50,50);
		bMypage.addActionListener(new ChangePanelListener());
		bMypage.setIcon(menu_Image);

		search_Button=new JButton("검색");
		search_Button.setBounds(40,360,400,40);
		search_Button.setBackground(Color.orange);
		search_Button.addActionListener(new ChangePanelListener());

		start_Point_Button=new JButton("선택");
		start_Point_Button.setBounds(20,120,110,70);

		start_Point_Button.addActionListener(new ChangePanelListener());
		start_Point_Button.setBackground(Color.white);

		destination_Point_Button=new JButton("선택");
		destination_Point_Button.setBounds(350,120,110,70);
		destination_Point_Button.addActionListener(new ChangePanelListener());
		destination_Point_Button.setBackground(Color.white);

		date_Button=new JButton("선택");
		date_Button.setBounds(260, 235, 200, 38);
		date_Button.addActionListener(new ChangePanelListener());
		date_Button.setBackground(Color.white);


		plane_Reserve_Button=new JButton();
		plane_Reserve_Button.setBounds(64, 206, 76, 50);
		plane_Reserve_Button.addActionListener(new ChangePanelListener());
		plane_Reserve_Button.setBorderPainted(false);
		plane_Reserve_Button.setContentAreaFilled(false);
		plane_Reserve_Button.setFocusPainted(false);

		sign_Up_Button=new JButton();
		sign_Up_Button.setBounds(155, 200, 70, 70);
		sign_Up_Button.addActionListener(new ChangePanelListener());
		//sign_Up_Button.setBorderPainted(false);
		sign_Up_Button.setContentAreaFilled(false);
		sign_Up_Button.setFocusPainted(false);
		sign_Up_Button.setIcon(sign_Up_Image);

		login_Button=new JButton();
		login_Button.setBounds(245, 200, 70, 70);
		login_Button.addActionListener(new ChangePanelListener());
		//login_Button.setBorderPainted(false);
		login_Button.setContentAreaFilled(false);
		login_Button.setFocusPainted(false);
		login_Button.setIcon(login_Image);

		back_a4_Button=new JButton(back_Image);
		back_a4_Button.setBounds(10, 10, 20, 25);
		back_a4_Button.addMouseListener(new MyMouseListener());
		back_a4_Button.addActionListener(new ChangePanelListener());
		back_a4_Button.setIcon(back_Image);
		back_a4_Button.setContentAreaFilled(false);

		back_A13=new JButton(back_Image);
		back_A13.setBounds(10, 10, 20, 25);
		back_A13.addMouseListener(new MyMouseListener());
		back_A13.addActionListener(new ChangePanelListener());
		back_A13.setIcon(back_Image);
		back_A13.setContentAreaFilled(false);





		back_a4_Button2=new JButton(back_Image);
		back_a4_Button2.setBounds(10, 10, 20, 25);
		back_a4_Button2.addMouseListener(new MyMouseListener());
		back_a4_Button2.addActionListener(new ChangePanelListener());
		back_a4_Button2.setIcon(back_Image);
		back_a4_Button2.setContentAreaFilled(false);


		back_Start_Button=new JButton(back_Image);
		back_Start_Button.setBounds(10, 10, 20, 25);
		back_Start_Button.addMouseListener(new MyMouseListener());
		back_Start_Button.addActionListener(new ChangePanelListener());
		back_Start_Button.setIcon(back_Image);
		back_Start_Button.setContentAreaFilled(false);

		start_Area_Button=new JButton("선택");
		start_Area_Button.setBounds(27, 190, 76, 35);
		start_Area_Button.addMouseListener(new MyMouseListener());
		start_Area_Button.addActionListener(new ChangePanelListener());

		back_Search_Button=new JButton(back2_Image);
		back_Search_Button.setBounds(30, 56, 20, 25);
		back_Search_Button.addMouseListener(new MyMouseListener());
		back_Search_Button.addActionListener(new ChangePanelListener());
		back_Search_Button.setIcon(back2_Image);
		back_Search_Button.setContentAreaFilled(false);

		end_Area_Button=new JButton("선택");
		end_Area_Button.setBounds(400, 190, 76, 35);
		end_Area_Button.addMouseListener(new MyMouseListener());
		end_Area_Button.addActionListener(new ChangePanelListener());

		sign_Up_finish_Button=new JButton("완료");
		sign_Up_finish_Button.setBounds(200, 290, 76, 35);
		sign_Up_finish_Button.addMouseListener(new MyMouseListener());
		sign_Up_finish_Button.addActionListener(new SingUpButtonListener());
		sign_Up_finish_Button.setBackground(Color.white);

		login_Check_Button=new JButton("완료");
		login_Check_Button.setBounds(200, 290, 76, 35);
		login_Check_Button.addMouseListener(new MyMouseListener());
		login_Check_Button.addActionListener(new LoginCheckListener());
		login_Check_Button.setBackground(Color.white);



		head_Count_Box =new JComboBox(head_Box);
		head_Count_Box.setBounds(210,310,250,25);
		head_Count_Box.setOpaque(false);


		start_Date_Label = new JLabel("  12월");
		start_Date_Label.setFont(new Font("돋움",Font.BOLD,40));
		start_Date_Label.setBounds(180,20,250,40);

		country_Label = new JLabel("출발지");
		country_Label.setFont(new Font("돋움",Font.BOLD,40));
		country_Label.setBounds(180,20,250,40);

		country_Label2 = new JLabel("도착지");
		country_Label2.setFont(new Font("돋움",Font.BOLD,40));
		country_Label2.setBounds(180,20,250,40);

		start_Point_Label= new JLabel("출발지");
		start_Point_Label.setBounds(20,70,100,50);
		start_Point_Label.setFont(new Font("돋움",Font.BOLD,20));
		destination_Point_Label= new JLabel("도착지");
		destination_Point_Label.setBounds(400,70,100,50);
		destination_Point_Label.setFont(new Font("돋움",Font.BOLD,20));
		date_Label= new JLabel("가는날");
		date_Label.setFont(new Font("돋움",Font.BOLD,18));
		airplane_title_Label= new JLabel("항공권 검색");
		airplane_title_Label.setFont(new Font("돋움",Font.BOLD,40));
		airplane_title_Label.setBounds(130,20,250,40);
		head_Count_Label= new JLabel("인원수 :");
		head_Count_Label.setFont(new Font("돋움",Font.BOLD,17));
		head_Count_Label.setBounds(30,300,250,40);
		user_Name_Label =new JLabel("이름");user_Age_Label= new JLabel("나이");
		user_Id_Label= new JLabel("아이디");user_Password_Label= new JLabel("비밀번호");

		user_Id_Label2=new JLabel("아이디");user_Id_Field2=new JTextField();

		user_Id_Label3=new JLabel("아이디");
		user_Password_Label3=new JLabel("비밀번호");
		user_Password_Label2=new JLabel("비밀번호");user_Password_Field2=new JPasswordField();
		Password_Field=new JTextField();;
		newPassword_Field=new JTextField();
		Id_Field =new JTextField();
		user_Name_Field =new JTextField();user_Age_Field =new JTextField();
		user_Id_Field =new JTextField();user_Password_Field =new JTextField();
		new_Password_Label=new JLabel("새 비밀번호");
		user_Name_Label.setBounds(100,100,50,30); user_Name_Field.setBounds(200, 100, 200, 30);
		user_Age_Label.setBounds(100,140,50,30);  user_Age_Field.setBounds(200, 140, 200, 30);
		user_Id_Label.setBounds(100,180,50,30);  user_Id_Field.setBounds(200, 180, 200, 30);

		Id_Field.setBounds(200, 220, 200, 30);Password_Field.setBounds(200, 280, 200, 30);
		newPassword_Field.setBounds(200, 340, 200, 30);
		user_Id_Label3.setBounds(100, 220, 200, 30);user_Password_Label3.setBounds(100, 280, 200, 30);
		new_Password_Label.setBounds(100, 340, 200, 30);
		user_Password_Label.setBounds(100,220,150,30);  user_Password_Field.setBounds(200, 220, 200, 30);

		user_Id_Label2.setBounds(100,180,50,30);  user_Id_Field2.setBounds(200, 180, 200, 30);
		user_Password_Label2.setBounds(100,220,150,30);  user_Password_Field2.setBounds(200, 220, 200, 30);
		date_Label.setBounds(30,200,100,100);
		card =new CardLayout(0,0);
		frame=new JFrame();

		changePassword_Panel=new ChangePasswordPanel();
		function_Panel=new FunctionPanel();
		confim_Panel=new ConfimPanel();
		date_Frame_Panel=new DatePanel();	
		final_Confirm_Flight_Panel=new FinalConfirmFlightPanel();
		confirm_Flight_Panel = new ConfirmFlightPanel();
		flight_Panel =new FlightsPanel();
		flight_Select_Panel=new FlightSelectPanel();
		start_County_Panel = new JPanel();
		end_Country_Panel =new JPanel();
		airplanePanel = new SearchAirPlanePanel();
		adminPanel = new JPanel();
		login_Panel=new JPanel();
		sign_up_frame_Panel = new JPanel();
		sign_Up_Panel=new Sign_Up_Panel();
		start_Panel=new StartPanel();

		seat_Select_Panel=new SeatSelectPanel();
		seat_Panel= new SeatPanel();
		select_Start_Area_Panel = new SelectAreaPanel();
		select_End_Area_Panel=new SelectAreaPanel();	
		datePanel=new JPanel(new GridLayout(7,7));
		datePanel.setBounds(40,100,400,300);
		start_County_Panel.setLayout(new GridLayout(3,1));
		start_County_Panel.setBounds(90,100,300,300);
		end_Country_Panel.setLayout(new GridLayout(3,1));
		end_Country_Panel.setBounds(90,100,300,300);

		flight_Select_Panel.setLayout(null);
		seat_Panel.setLayout(null);
		flight_Panel.setLayout(new GridLayout(list.size(),1));
		seat_Select_Panel.setLayout(null);
		scroll1 =new JScrollPane(flight_Panel);
		scroll1.setBounds(0, 150, 480, 350);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scroll2 =new JScrollPane(seat_Select_Panel);
		scroll2.setBounds(0, 150, 480, 250);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		seat_Panel.add(scroll2);
		seatMake();

		changePassword_Panel.setLayout(null);
		function_Panel.setLayout(null);
		flight_Panel.setPreferredSize(new Dimension(500,1000));
		seat_Select_Panel.setPreferredSize(new Dimension(500,700));
		//flight_Select_Panel.add(flight_Panel);
		flight_Select_Panel.add(scroll1);
		date_Frame_Panel.setLayout(null);
		airplanePanel.setLayout(null);
		login_Panel.setLayout(null);
		sign_up_frame_Panel.setLayout(new BorderLayout());
		sign_Up_Panel.setLayout(null);
		start_Panel.setLayout(null);
		select_Start_Area_Panel.setLayout(null);
		select_End_Area_Panel.setLayout(null);
		test=new JButton[50];

		for(int i=0;i<=6;i++)
			datePanel.add(week[i]);
		for(int i=37;i<=42;i++) {
			date_Sellect_Button[i].setEnabled(false);
			datePanel.add(date_Sellect_Button[i]);
		}
		for(int i=1;i<=31;i++)
			datePanel.add(date_Sellect_Button[i]);
		for(int i=32;i<=36;i++) {
			date_Sellect_Button[i].setEnabled(false);
			datePanel.add(date_Sellect_Button[i]);
		}
		for(int i=1;i<=28;i++) {
			date_Sellect_Button[i].setEnabled(false);
		}

		function_Panel.add(changePassword);
		function_Panel.add(back_a4_Button2);
		function_Panel.add(bPrint);
		function_Panel.add(bPreview);
		mainPanel=new JPanel();
		mainPanel.setLayout(card);

		mainPanel.add("a1",start_Panel);
		mainPanel.add("a2",sign_up_frame_Panel);
		mainPanel.add("a3",login_Panel);
		mainPanel.add("a4",airplanePanel);
		mainPanel.add("a5",select_Start_Area_Panel);
		mainPanel.add("a6",select_End_Area_Panel);
		mainPanel.add("a7",date_Frame_Panel);
		mainPanel.add("a8",flight_Select_Panel);
		mainPanel.add("a10",seat_Panel);
		mainPanel.add("a12",confim_Panel);
		mainPanel.add("a13",function_Panel);
		mainPanel.add("a14",changePassword_Panel);

		frame.add(mainPanel);
		card.show(mainPanel	, "a1");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize (new Dimension(WIDTH,A1_HEIGHT));
		frame.pack();

		frame.setVisible(true);


		changePassword_Panel.add(doChange_Buttone);
		changePassword_Panel.add(new_Password_Label);
		changePassword_Panel.add(back_A13);
		changePassword_Panel.add(user_Id_Label3);
		changePassword_Panel.add(user_Password_Label3);
		changePassword_Panel.add(Password_Field);
		changePassword_Panel.add(newPassword_Field);
		changePassword_Panel.add(Id_Field);

		airplanePanel.add(bMypage);
		date_Frame_Panel.add(start_Date_Label);
		date_Frame_Panel.add(datePanel);
		select_Start_Area_Panel.add(start_County_Panel);
		select_Start_Area_Panel.add(country_Label);
		start_County_Panel.add(start_Korea);
		start_County_Panel.add(start_Germany);
		start_County_Panel.add(start_Russia);
		start_County_Panel.add(start_Japan);
		start_County_Panel.add(start_Usa);
		start_County_Panel.add(start_Singapore);
		start_County_Panel.add(start_France);

		select_End_Area_Panel.add(end_Country_Panel);
		select_End_Area_Panel.add(country_Label2);
		end_Country_Panel.add(end_Korea);
		end_Country_Panel.add(end_Germany);
		end_Country_Panel.add(end_Russia);
		end_Country_Panel.add(end_Japan);
		end_Country_Panel.add(end_Usa);
		end_Country_Panel.add(end_Singapore);
		end_Country_Panel.add(end_France);

		airplanePanel.add(search_Button);
		airplanePanel.add(head_Count_Box);
		airplanePanel.add(head_Count_Label);
		airplanePanel.add(date_Label);
		airplanePanel.add(airplane_title_Label);
		airplanePanel.add(start_Point_Label);
		airplanePanel.add(destination_Point_Label);
		airplanePanel.add(start_Point_Button);
		airplanePanel.add(destination_Point_Button);
		airplanePanel.add(date_Button);

		//start_Panel.add(plane_Reserve_Button);
		login_Panel.setBackground(Color.WHITE);
		login_Panel.add(user_Id_Label2);
		login_Panel.add(user_Id_Field2);
		login_Panel.add(user_Password_Label2);
		login_Panel.add(user_Password_Field2);
		login_Panel.add(login_Label2);
		login_Panel.add(login_Check_Button);
		login_Panel.add(login_check_Label);


		start_Panel.add(sign_Up_Label);
		start_Panel.add(login_Label);
		start_Panel.add(sign_Up_Button);
		start_Panel.add(login_Button);
		sign_Up_Panel.setSize(300, 500);

		sign_up_frame_Panel.add(sign_Up_Panel,BorderLayout.CENTER);
		sign_Up_Panel.add(sign_Up_Label2);
		sign_Up_Panel.add(user_Name_Label);sign_Up_Panel.add(user_Name_Field);
		sign_Up_Panel.add(user_Age_Label);sign_Up_Panel.add(user_Age_Field);
		sign_Up_Panel.add(user_Id_Label);sign_Up_Panel.add(user_Id_Field);
		sign_Up_Panel.add(user_Password_Label);sign_Up_Panel.add(user_Password_Field);
		sign_Up_Panel.add(sign_Up_finish_Button);
		sign_Up_Panel.add(overlap_Id_Label);

		//search_AirPlane_Panel.add(back_Start_Button);
		//select_Start_Area_Panel.add(back_Search_Button);
		//select_Start_Area_Panel.add(back_Search_Button);
	}

	public void startSelect() {


	}
	public void loginClear(){

		user_Id_Field2.setText("");
		user_Password_Field2.setText("");
		login_check_Label.setText("");

	}
	public void signUpClear() {
		user_Name_Field.setText("");
		user_Age_Field.setText("");
		user_Id_Field.setText("");
		user_Password_Field.setText("");
		overlap_Id_Label.setText("");	
	}
	public void selectflight() {
		try {
			Statement stmt = conn.createStatement();			// SQL 문을 작성을 위한  Statement 객체 생성

			// 현재 DB에 있는 내용 추출해서 강아지 목록을 names 리스트에 출력하기
			ResultSet rs = stmt.executeQuery("SELECT flight_id 번호,(SELECT country_name FROM country WHERE country_id=starting_id) 출발지,"
					+ "(SELECT country_name FROM country WHERE country_id=destination_id) 도착지,flight_t 비행시간, departure_t 출발시간, arrival_t 도착시간,"
					+ " airline_name 항공사,base_fee 기본요금 FROM flight NATURAL JOIN flight_line fl NATURAL JOIN airline a WHERE fl.starting_id"
					+ " =(SELECT country_id FROM country WHERE country_name = '"+starting_Point+"') AND \r\n" + 
					"fl.destination_id=(SELECT country_id FROM country WHERE country_name = '"+destination_Point +"') AND departure_date='"+date+"';");

			while (rs.next()) {
				list.add(new FlightMakePanel(rs.getString("출발지"),rs.getString("도착지"),rs.getString("출발시간"),rs.getString("도착시간"),
						rs.getString("비행시간"),rs.getString("항공사"),rs.getString("기본요금"),rs.getInt("번호")));


			}
			rs.close();

			stmt.close();			
			for (FlightMakePanel r : list) {
				flight_Panel.add(r);
			}	
			flight_Panel.setPreferredSize(new Dimension(500,list.size()*110));

			//flight_Panel.add(list)
			// statement는 사용후 닫는 습관
			// names의 각종 속성은 그대로 두고 내용물만 바꾼다
		} catch (SQLException sqlex) {
			System.out.println("SQL 에러 : " + sqlex.getMessage());
			sqlex.printStackTrace();
		}
	}
	public class StartPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.setColor(java.awt.Color.white);
			g.fillRect(0, 0, 500, 400);
			g.drawImage(start_image.getImage(), 0, 0, 456, 188,null);
			//g.drawImage(sign_Up_Image.getImage(), 100, 200, 70, 70,null);
			//	g.drawImage(air_Ticket_Image.getImage(), 200, 200, 70, 70,null);
		}
	}

	public class Sign_Up_Panel extends JPanel {
		public void paintComponent(Graphics g) {
			g.setColor(java.awt.Color.white);
			g.fillRect(0, 0, 500, 400);

		}
	}


	public class SearchAirPlanePanel extends JPanel {
		public void paintComponent(Graphics g) {	
			g.setColor(new Color(54,138,255));
			g.fillRect(0, 0, 500, 550);
			g.setColor(Color.white);
			g.fillRoundRect(10, 80, 464, 130, 10, 10);
			g.drawImage(airplan_Image.getImage(),215, 130,50,50,null);
			g.fillRoundRect(10, 220, 464, 70, 10, 10);
			g.fillRoundRect(10, 300, 464, 130, 10, 10);
		}
	}
	public class SelectAreaPanel extends JPanel {
		public void paintComponent(Graphics g) {	
			g.setColor(new Color(54,138,255));
			g.fillRect(0, 0, 500, 550);
			g.setColor(Color.white);
			g.fillRoundRect(70,80,340,340, 10, 10);
			g.fillRoundRect(170,10,145,60, 10, 10);
		}
	}
	public class DatePanel extends JPanel {
		public void paintComponent(Graphics g) {	
			g.setColor(new Color(54,138,255));
			g.fillRect(0, 0, 500, 550);
			g.setColor(Color.white);
			g.fillRoundRect(20,80,440,340, 10, 10);
			g.fillRoundRect(170,10,145,60, 10, 10);
		}
	}


	public class SelectEndAreaPanel extends JPanel {
		public void paintComponent(Graphics g) {	
			g.drawImage(select_End_Area_Image.getImage(), 0, 0, 500, 865,null);
		}
	}
	public class FlightSelectPanel extends JPanel {
		JLabel t= new JLabel("항공편");


		public FlightSelectPanel(){
			t.setLayout(null);
			t.setBounds(170,0,150,150);
			t.setFont(new Font("돋움",Font.BOLD,40));
			this.add(t);
			this.add(back_a4_Button);
		}
		public void paintComponent(Graphics g) {	
			g.setColor(Color.white);
			g.fillRect(0, 0, 500, 700);
		}
	}
	public class FlightMakePanel extends JPanel implements ActionListener{
		JLabel starting,destination,starting_t,destination_t,fligting_t1,fligting_t2,ariline,price;
		JButton select;
		int key;
		ConfirmFlightPanel cf =new ConfirmFlightPanel();
		public FlightMakePanel(String s,String d,String s_t,String d_t,String f_t,String a,String p,int key) {
			starting =new JLabel(s);destination=new JLabel(d);starting_t=new JLabel(s_t);destination_t=new JLabel(d_t);fligting_t1=new JLabel("비행시간 :");
			fligting_t2=new JLabel(f_t);ariline=new JLabel(a); price=new JLabel(p);
			this.key=key;
			select =new JButton("선택");
			this.setLayout(null);
			this.setSize(500,250);
			starting.setBounds(10,0,100,50);
			destination.setBounds(170,0,100,50);
			starting_t.setBounds(10,14,100,50);
			destination_t.setBounds(170,14,100,50);
			fligting_t1.setBounds(10,40,100,50);
			fligting_t2.setBounds(100,40,100,50);
			ariline.setBounds(10,60,100,50);
			price.setBounds(300,0,100,50);
			select.setBounds(300,60,60,30);
			this.add(starting);
			this.add(destination);
			this.add(starting_t);
			this.add(destination_t);
			this.add(fligting_t1);
			this.add(fligting_t2);
			this.add(ariline);
			this.add(price);
			this.add(select);
			select.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==this.select) {
				flight_key=key;
				confirm_Flight_Panel = new ConfirmFlightPanel();
				mainPanel.add("a9",confirm_Flight_Panel);
				card.show(mainPanel	, "a9");


			}
		}
		public void paintComponent(Graphics g) {	
			g.setColor(Color.black);
			g.fillRect(0, 0, 480, 120);
			g.setColor(Color.white);
			g.fillRect(3, 3, 474, 114);
		}

	}
	public class FlightsPanel extends JPanel {
		public void paintComponent(Graphics g) {	
			g.setColor(Color.white);
			g.fillRect(0, 0, 500, 400);
		}
	}
	public class ConfirmFlightPanel extends JPanel implements ActionListener {
		JLabel starting,destination,starting_t,destination_t,fligting_t1,fligting_t2,ariline,price,key_Label;
		JLabel starting2,destination2,price2,key_Label2,ariline2,departure_date,departure_date2 ,t;
		String s,d,s_t,d_t,f_t,a,p,date;
		JButton seat,back;
		int key;
		Connection conn2;

		public ConfirmFlightPanel() {
			dbConnectionInit();
			select();

			starting =new JLabel(s);destination=new JLabel(d);starting_t=new JLabel(s_t);destination_t=new JLabel(d_t);fligting_t1=new JLabel("비행시간 :");
			fligting_t2=new JLabel(f_t);ariline=new JLabel(a); price=new JLabel(p); key_Label=new JLabel(key+"");
			starting2=new JLabel("출발지");destination2=new JLabel("도착지");price2=new JLabel("가격");key_Label2=new JLabel("항공편 넘버 :");
			ariline2 =new JLabel("항공사 :");departure_date=new JLabel(date);departure_date2=new JLabel("출발일 :");
			t=new JLabel("항공편 확인");
			seat=new JButton("좌석선택");back=new JButton("뒤로");  	


			back.setBounds(130,330,100,40);
			back.setBackground(Color.white);
			back.addActionListener(this);
			seat.addActionListener(this);
			seat.setBounds(250,330,100,40);
			seat.setBackground(Color.white);
			this.setLayout(null);
			this.setSize(500,700);
			t.setBounds(135,0,300,100);
			starting2.setBounds(40,120,100,50);
			destination2.setBounds(200,120,100,50);
			starting.setBounds(40,160,100,50);
			destination.setBounds(200,160,100,50);
			starting_t.setBounds(40,194,100,50);
			destination_t.setBounds(200,194,100,50);
			fligting_t1.setBounds(40,230,150,50);
			fligting_t2.setBounds(130,230,150,50);
			departure_date2.setBounds(280,230,150,50);
			departure_date.setBounds(360,230,150,50);
			ariline2.setBounds(40,250,150,50);
			ariline.setBounds(100,250,150,50);
			price2.setBounds(330,120,100,50);
			price.setBounds(330,160,100,50);
			key_Label2.setBounds(280,250,120,50);
			key_Label.setBounds(400,250,60,50);


			t.setFont(new Font("돋움",Font.BOLD,40));
			starting2.setFont(new Font("굴림",Font.BOLD,20));
			destination2.setFont(new Font("굴림",Font.BOLD,20));
			starting.setFont(new Font("굴림",Font.BOLD,15));
			starting2.setForeground(Color.blue);
			destination.setFont(new Font("굴림",Font.BOLD,15));
			destination2.setForeground(Color.blue);
			starting_t.setFont(new Font("굴림",Font.BOLD,15));
			destination_t.setFont(new Font("굴림",Font.BOLD,15));
			fligting_t1.setFont(new Font("굴림",Font.BOLD,15));
			fligting_t2.setFont(new Font("굴림",Font.BOLD,15));
			departure_date2.setFont(new Font("굴림",Font.BOLD,15));
			departure_date2.setForeground(Color.red);
			departure_date.setFont(new Font("굴림",Font.BOLD,15));
			ariline2.setFont(new Font("굴림",Font.BOLD,15));
			ariline.setFont(new Font("굴림",Font.BOLD,15));
			price2.setFont(new Font("굴림",Font.BOLD,20));
			price2.setForeground(Color.blue);
			price.setFont(new Font("굴림",Font.BOLD,15));
			key_Label2.setFont(new Font("굴림",Font.BOLD,15));
			key_Label.setFont(new Font("굴림",Font.BOLD,15));
			this.add(back);
			this.add(seat);
			this.add(t);
			this.add(starting2);
			this.add(destination2);
			this.add(starting);
			this.add(destination);
			this.add(starting_t);
			this.add(destination_t);
			this.add(fligting_t1);
			this.add(fligting_t2);
			this.add(departure_date2);
			this.add(departure_date);
			this.add(ariline2);
			this.add(ariline);
			this.add(price2);
			this.add(price);
			this.add(key_Label2);
			this.add(key_Label);

		}

		public void paintComponent(Graphics g) {	
			g.setColor(new Color(54,138,255));
			g.fillRect(0, 0, 500, 600);
			g.setColor(Color.white);
			g.fillRoundRect(10, 115, 464, 180, 10, 10);
			g.fillRoundRect(120, 15, 265, 75, 10, 10);
			g.fillRoundRect(10, 320, 464, 60, 10, 10);

		}
		public void select(){
			try { 
				Statement stmt = conn2.createStatement();	

				// SQL 문을 작성을 위한  Statement 객체 생성
				ResultSet rs = stmt.executeQuery("SELECT departure_date 출발일, flight_id 번호, (SELECT country_name FROM country WHERE country_id=starting_id) 출발지,"
						+ "(SELECT country_name FROM country WHERE country_id=destination_id) 도착지,flight_t 비행시간, departure_t 출발시간,"
						+ " arrival_t 도착시간, airline_name 항공사,base_fee 기본요금 FROM flight NATURAL JOIN flight_line fl NATURAL JOIN airline a WHERE flight_id="+flight_key+";");
				rs.next();

				s=rs.getString("출발지");
				d=rs.getString("도착지");
				s_t=rs.getString("출발시간");
				d_t=rs.getString("도착시간");
				f_t=rs.getString("비행시간");
				a=rs.getString("항공사");
				p=rs.getString("기본요금");
				date=rs.getString("출발일");
				key=rs.getInt("번호");

				rs.close();
				stmt.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			}
		}
		private void dbConnectionInit() {
			try {
				Class.forName("com.mysql.jdbc.Driver");					// JDBC드라이버를 JVM영역으로 가져오기
				conn2 = DriverManager.getConnection("jdbc:mariadb://localhost:3306/project", "root", "");	// DB 연결하기

			}
			catch (ClassNotFoundException cnfe) {
				System.out.println("JDBC 드라이버 클래스를 찾을 수 없습니다 : " + cnfe.getMessage());
			}
			catch (Exception ex) {
				System.out.println("DB 연결 에러 : " + ex.getMessage());
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==back) {
				mainPanel.remove(confirm_Flight_Panel);
				mainPanel.add("a9",confirm_Flight_Panel);
				card.show(mainPanel	, "a8");
				mainPanel.repaint();
			}
			else if(e.getSource()==seat) {			

				try { 
					Statement stmt = conn2.createStatement();	
					// SQL 문을 작성을 위한  Statement 객체 생성

					ResultSet rs = stmt.executeQuery("SELECT seat_id FROM flight_seat WHERE flight_id="+flight_key+" AND is_full='y';");
					while(rs.next()) {
						seats[rs.getInt("seat_id")].setEnabled(false);	
						seats[rs.getInt("seat_id")].setBackground(new Color(255,90,90));

					}
					rs.close();
					stmt.close();
				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				}

				card.show(mainPanel	, "a10");
				mainPanel.repaint();
			}
		}
	}
	public class SeatSelectPanel extends JPanel {

		public void paintComponent(Graphics g) {	
			g.setColor(Color.white);
			g.fillRect(0, 0, 500, 600);

			g.setColor(Color.green);
			g.fillRect(0, 0, 500, 350);
			g.setColor(Color.orange);
			g.fillRect(0, 350, 500, 210);
			g.setColor(Color.red);
			g.fillRect(0, 560, 500, 140);
		}

	}
	public class SeatPanel extends JPanel implements ActionListener {

		JLabel t;
		JButton back,reserve;
		public SeatPanel() {
			t=new JLabel("좌석선택");
			t.setLayout(null);
			t.setBounds(175,0,200,110);
			t.setFont(new Font("돋움",Font.BOLD,35));
			reserve=new JButton("예약");
			back=new JButton("뒤로");	
			this.add(t);
			this.add(back);
			this.add(reserve);
			back.addActionListener(this);
			back.setBounds(130, 455, 80, 40);
			reserve.addActionListener(this);
			reserve.setBounds(270, 455, 80, 40);
		}
		public void paintComponent(Graphics g) {	
			g.setColor(new Color(54,138,255));
			g.fillRect(0, 0, 500, 600);

			g.setColor(Color.white);
			g.fillRoundRect(120, 15, 265, 75, 10, 10);
			g.setColor(Color.white);
			g.fillRoundRect(0, 125, 484, 300, 10, 10);
			g.fillRoundRect(0, 450, 484, 50, 10, 10);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==back) {
				for(int i=1;i<41;i++) {
					seat_Check[i]=false;
					seats[i].setBackground(new Color(206,242,121));
				}
				list_seat.clear();
				card.show(mainPanel	, "a9");
			}
			if(e.getSource()==reserve) {
				final_Confirm_Flight_Panel = new FinalConfirmFlightPanel();
				mainPanel.add("a11",final_Confirm_Flight_Panel);
				final_Confirm_Flight_Panel.setSelectSeat();
				final_Confirm_Flight_Panel.select();
				card.show(mainPanel	, "a11");
			}
		}
	}
	public class FinalConfirmFlightPanel extends JPanel implements ActionListener {
		JLabel starting,destination,starting_t,destination_t,fligting_t1,fligting_t2,ariline,price,key_Label;
		JLabel starting2,destination2,price2,key_Label2,ariline2,departure_date,departure_date2 ,t;
		JLabel selected_Seat,selected_Seat2;
		String s,d,s_t,d_t,f_t,a,p,date;
		JButton finalreserve,back;
		int key ,total_price=0,price_int;
		Connection conn2;
		String seat="";
		public FinalConfirmFlightPanel() {
			dbConnectionInit();
			select();

			starting =new JLabel(s);destination=new JLabel(d);starting_t=new JLabel(s_t);destination_t=new JLabel(d_t);fligting_t1=new JLabel("비행시간 :");
			fligting_t2=new JLabel(f_t);ariline=new JLabel(a); price=new JLabel(p); key_Label=new JLabel(key+"");
			starting2=new JLabel("출발지");destination2=new JLabel("도착지");price2=new JLabel("총 가격");key_Label2=new JLabel("항공편 넘버 :");
			ariline2 =new JLabel("항공사 :");departure_date=new JLabel(date);departure_date2=new JLabel("출발일 :");
			t=new JLabel("예약 확인");
			finalreserve=new JButton("예약");back=new JButton("뒤로");  	
			selected_Seat =new JLabel();selected_Seat2 = new JLabel("선택 좌석 :");


			back.setBounds(130,430,100,40);
			back.setBackground(Color.white);
			back.addActionListener(this);
			finalreserve.addActionListener(this);
			finalreserve.setBounds(250,430,100,40);
			finalreserve.setBackground(Color.white);
			this.setLayout(null);
			this.setSize(500,700);
			selected_Seat2.setBounds(40,330,100,40);
			selected_Seat.setBounds(210,330,250,40);
			t.setBounds(135,0,300,100);
			starting2.setBounds(40,120,100,50);
			destination2.setBounds(200,120,100,50);
			starting.setBounds(40,160,100,50);
			destination.setBounds(200,160,100,50);
			starting_t.setBounds(40,194,100,50);
			destination_t.setBounds(200,194,100,50);
			fligting_t1.setBounds(40,230,150,50);
			fligting_t2.setBounds(130,230,150,50);
			departure_date2.setBounds(280,230,150,50);
			departure_date.setBounds(360,230,150,50);
			ariline2.setBounds(40,250,150,50);
			ariline.setBounds(100,250,150,50);
			price2.setBounds(330,120,100,50);
			price.setBounds(330,160,100,50);
			key_Label2.setBounds(280,250,120,50);
			key_Label.setBounds(400,250,60,50);


			t.setFont(new Font("돋움",Font.BOLD,40));
			starting2.setFont(new Font("굴림",Font.BOLD,20));
			destination2.setFont(new Font("굴림",Font.BOLD,20));
			starting.setFont(new Font("굴림",Font.BOLD,15));
			starting2.setForeground(Color.blue);
			destination.setFont(new Font("굴림",Font.BOLD,15));
			destination2.setForeground(Color.blue);
			starting_t.setFont(new Font("굴림",Font.BOLD,15));
			destination_t.setFont(new Font("굴림",Font.BOLD,15));
			fligting_t1.setFont(new Font("굴림",Font.BOLD,15));
			fligting_t2.setFont(new Font("굴림",Font.BOLD,15));
			departure_date2.setFont(new Font("굴림",Font.BOLD,15));
			departure_date2.setForeground(Color.red);
			departure_date.setFont(new Font("굴림",Font.BOLD,15));
			ariline2.setFont(new Font("굴림",Font.BOLD,15));
			ariline.setFont(new Font("굴림",Font.BOLD,15));
			price2.setFont(new Font("굴림",Font.BOLD,20));
			price2.setForeground(Color.blue);
			price.setFont(new Font("굴림",Font.BOLD,15));
			key_Label2.setFont(new Font("굴림",Font.BOLD,15));
			key_Label.setFont(new Font("굴림",Font.BOLD,15));
			selected_Seat.setFont(new Font("굴림",Font.BOLD,15));
			selected_Seat2.setFont(new Font("굴림",Font.BOLD,15));
			this.add(back);
			this.add(finalreserve);
			this.add(t);
			this.add(starting2);
			this.add(destination2);
			this.add(starting);
			this.add(destination);
			this.add(starting_t);
			this.add(destination_t);
			this.add(fligting_t1);
			this.add(fligting_t2);
			this.add(departure_date2);
			this.add(departure_date);
			this.add(ariline2);
			this.add(ariline);
			this.add(price2);
			this.add(price);
			this.add(key_Label2);
			this.add(key_Label);
			this.add(selected_Seat);
			this.add(selected_Seat2);

		}

		public void paintComponent(Graphics g) {	
			g.setColor(new Color(54,138,255));
			g.fillRect(0, 0, 500, 600);
			g.setColor(Color.white);
			g.fillRoundRect(10, 115, 464, 180, 10, 10);
			g.fillRoundRect(120, 15, 265, 75, 10, 10);
			g.fillRoundRect(10, 320, 464, 60, 10, 10);

		}
		public void setSelectSeat() {

			for(int i=0;i<list_seat.size();i++) {

				if(Integer.parseInt(list_seat_n.get(i))<20)
					total_price=(price_int+price_int);
				else if(Integer.parseInt(list_seat_n.get(i))<32)
					total_price=(price_int+price_int*2);
				else if(Integer.parseInt(list_seat_n.get(i))<40)
					total_price=(price_int+price_int*4);
			}

			price.setText(total_price+"");

			Collections.sort(list_seat);
			for (int i=0;i<list_seat.size();i++) {
				seat=seat+"  "+list_seat.get(i);

			}	
			selected_Seat.setText(seat);
		}
		public void select(){
			try { 
				Statement stmt = conn2.createStatement();	

				// SQL 문을 작성을 위한  Statement 객체 생성
				ResultSet rs = stmt.executeQuery("SELECT departure_date 출발일, flight_id 번호, (SELECT country_name FROM country WHERE country_id=starting_id) 출발지,"
						+ "(SELECT country_name FROM country WHERE country_id=destination_id) 도착지,flight_t 비행시간, departure_t 출발시간,"
						+ " arrival_t 도착시간, airline_name 항공사,base_fee 기본요금 FROM flight NATURAL JOIN flight_line fl NATURAL JOIN airline a WHERE flight_id="+flight_key+";");
				rs.next();

				s=rs.getString("출발지");
				d=rs.getString("도착지");
				s_t=rs.getString("출발시간");
				d_t=rs.getString("도착시간");
				f_t=rs.getString("비행시간");
				a=rs.getString("항공사");
				p=rs.getString("기본요금");
				date=rs.getString("출발일");
				key=rs.getInt("번호");

				price_int=Integer.parseInt(p);
				rs.close();
				stmt.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			}
		}
		private void dbConnectionInit() {
			try {
				Class.forName("com.mysql.jdbc.Driver");					// JDBC드라이버를 JVM영역으로 가져오기
				conn2 =DriverManager.getConnection("jdbc:mariadb://localhost:3306/project", "root", "");	// DB 연결하기

			}
			catch (ClassNotFoundException cnfe) {
				System.out.println("JDBC 드라이버 클래스를 찾을 수 없습니다 : " + cnfe.getMessage());
			}
			catch (Exception ex) {
				System.out.println("DB 연결 에러 : " + ex.getMessage());
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==back) {
				list_seat.clear();
				list_seat_n.clear();
				for(int i=1;i<41;i++) {
					seat_Check[i]=false;
					seats[i].setBackground(new Color(206,242,121));
				}
				seat="";
				list_seat.clear();
				card.show(mainPanel	, "a10");
				mainPanel.repaint();
			}
			else if(e.getSource()==finalreserve) {			

				try { 
					Statement stmt = conn2.createStatement();	
					for(int i=0;i<list_seat_n.size();i++) {

						stmt.executeUpdate("INSERT INTO reserve (flight_id, customer_id, price, seat_id) VALUES \r\n" + 
								"("+flight_key+", '"+user_Id+"' , "+total_price+" ,"+Integer.parseInt(list_seat_n.get(i))+")");
						stmt.executeUpdate("\r\n" + 
								"INSERT INTO flight_seat (flight_id, seat_id, is_full) VALUES \r\n" + 
								"("+flight_key+", "+Integer.parseInt(list_seat_n.get(i))+", 'y');");

					}

					stmt.close();
				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				}
				list_seat.clear();
				list_seat_n.clear();
				for(int i=1;i<41;i++) {
					seat_Check[i]=false;
					seats[i].setBackground(new Color(206,242,121));
				}
				card.show(mainPanel	, "a12");
			}
		}
	}
	public class ConfimPanel extends JPanel implements ActionListener {
		JButton confirm;
		JLabel confirm_l;
		public ConfimPanel() {
			this.setLayout(null);
			confirm=new JButton("확인");
			confirm_l=new JLabel("예매가 완료되었습니다.");
			confirm_l.setFont(new Font("굴림",Font.BOLD,15));
			confirm_l.setBounds(165, 248, 200, 60);
			confirm.setBounds(215, 290, 60, 25);
			confirm.addActionListener(this);
			this.add(confirm_l);
			repaint();this.add(confirm);
		}
		public void paintComponent(Graphics g) {	
			g.setColor(Color.black);
			g.fillRect(115, 250,260, 80);
			g.setColor(Color.white);
			g.fillRect(125, 260,240, 60);

		}
		@Override
		public void actionPerformed(ActionEvent e) {
			start_Point_Button.setText("선택");
			destination_Point_Button.setText("선택");
			date_Button.setText("선택");
			start_Point_Button.setBackground(Color.white);
			destination_Point_Button.setBackground(Color.white);
			head_Count_Box.setSelectedIndex(0);
			if(e.getSource()==confirm) {
				card.show(mainPanel	, "a4");
			}
		}	
	}
	public class FunctionPanel extends JPanel   {
		JLabel t;
		JLabel print_L,preview_L;
		JLabel reserve_L;

		public FunctionPanel() {

			this.setLayout(null);
			reserve_L=new JLabel("예약내역 : ");
			print_L =new JLabel("예매내역 프린트하기");
			preview_L =new JLabel("예매내역 미리보기");
			print_L.setBounds(10,230,200,50);
			preview_L.setBounds(10,300,200,50);
			t=new JLabel("내 정보");
			t.setLayout(null);
			t.setBounds(190,0,200,110);
			reserve_L.setBounds(10,170,200,50);
			reserve_L.setFont(new Font("돋움",Font.BOLD,18));
			print_L.setFont(new Font("돋움",Font.BOLD,18));
			preview_L.setFont(new Font("돋움",Font.BOLD,18));
			t.setFont(new Font("돋움",Font.BOLD,35));
			this.add(t);this.add(print_L);this.add(preview_L);this.add(reserve_L);this.add(delete_Reserve);

		}
		public void paintComponent(Graphics g) {	
			g.setColor(new Color(54,138,255));
			g.fillRect(0, 0, 500, 600);
			g.setColor(Color.white);
			g.fillRoundRect(120, 15, 265, 75, 10, 10);
			g.setColor(Color.white);
			g.fillRoundRect(0, 125, 484, 300, 10, 10);

		}


	}
	public class ChangePasswordPanel extends JPanel   {
		JLabel t;
		JLabel print_L,preview_L;
		JLabel reserve_L;

		public ChangePasswordPanel() {

			this.setLayout(null);

			t=new JLabel("비밀번호 변경");
			t.setLayout(null);
			t.setBounds(144,0,300,110);

			t.setFont(new Font("돋움",Font.BOLD,35));
			this.add(t);

		}
		public void paintComponent(Graphics g) {	
			g.setColor(new Color(54,138,255));
			g.fillRect(0, 0, 500, 600);
			g.setColor(Color.white);
			g.fillRoundRect(120, 15, 265, 75, 10, 10);
			g.setColor(Color.white);
			g.fillRoundRect(0, 125, 484, 300, 10, 10);

		}


	}
	private class ChangePanelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==sign_Up_Button) {
				card.show(mainPanel	, "a2");
				sign_Up_Panel.add(back_Start_Button);
				mainPanel.repaint();
			}
			else if(e.getSource()==login_Button) {
				card.show(mainPanel	, "a3");
				login_Panel.add(back_Start_Button);
				//select_Start_Area_Panel.add(back_Search_Button);

				mainPanel.repaint();
			}
			else if(e.getSource()==start_Point_Button) {
				card.show(mainPanel	, "a5");
				//select_End_Area_Panel.add(back_Search_Button);
				mainPanel.repaint();
			}
			else if(e.getSource()==destination_Point_Button) {
				card.show(mainPanel	, "a6");
				//select_End_Area_Panel.add(back_Search_Button);
				mainPanel.repaint();
			}
			else if(e.getSource()==date_Button) {
				card.show(mainPanel	, "a7");
				mainPanel.repaint();
			}
			else if(e.getSource()==search_Button) {
				selectflight();
				head_Count=head_Count_Box.getSelectedItem().toString();
				card.show(mainPanel	, "a8");
				mainPanel.repaint();
			}
			else if(e.getSource()==back_a4_Button2) {
				card.show(mainPanel	, "a4");

			}
			else if(e.getSource()==back_a4_Button) {

				for (FlightMakePanel r : list) {
					flight_Panel.remove(r);
				}	
				list.clear();


				card.show(mainPanel	, "a4");
				mainPanel.repaint();
			}
			else if(e.getSource()==bMypage) {
				reserve_Box.removeAllItems();
				properties();
				function_Panel.add(reserve_Box);
				card.show(mainPanel	, "a13");
			}


			else if(e.getSource()==back_Start_Button) {
				card.show(mainPanel	, "a1");
				loginClear();  
				signUpClear();
				mainPanel.repaint();
				frame.setPreferredSize (new Dimension(WIDTH,A1_HEIGHT));
			}
			else if(e.getSource()==back_Search_Button) {
				card.show(mainPanel	, "a2");
				mainPanel.repaint();
			}
			else if(e.getSource()==changePassword) {
				showMyPassword();
				card.show(mainPanel	, "a14");
				mainPanel.repaint();
			}
			else if(e.getSource()==back_A13) {
				card.show(mainPanel	, "a13");
				mainPanel.repaint();
			}
			else if(e.getSource()==doChange_Buttone) {
				ChangeMyPassword();
				mainPanel.repaint();
			}


		}

	}

	private class SelectStartActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==start_Korea) {
				starting_Point="한국";
			}
			else if(e.getSource()==start_Germany) {
				starting_Point="독일";
			}
			else if(e.getSource()==start_Russia) {
				starting_Point="러시아";
			}
			else if(e.getSource()==start_Usa) {
				starting_Point="미국";
			}
			else if(e.getSource()==start_Japan) {
				starting_Point="일본";
			}
			else if(e.getSource()==start_Singapore) {
				starting_Point="싱가포르";
			}
			else if(e.getSource()==start_France) {
				starting_Point="프랑스";
			}
			start_Point_Button.setText(starting_Point);
			start_Point_Button.setBackground(new Color(180,255,255));
			card.show(mainPanel	, "a4");
		}

	}
	private class SelectEndActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==end_Korea) {
				destination_Point="한국";
			}
			else if(e.getSource()==end_Germany) {
				destination_Point="독일";
			}
			else if(e.getSource()==end_Russia) {
				destination_Point="러시아";
			}
			else if(e.getSource()==end_Usa) {
				destination_Point="미국";
			}
			else if(e.getSource()==end_Japan) {
				destination_Point="일본";
			}
			else if(e.getSource()==end_Singapore) {
				destination_Point="싱가포르";
			}
			else if(e.getSource()==end_France) {
				destination_Point="프랑스";
			}
			destination_Point_Button.setText(destination_Point);
			destination_Point_Button.setBackground(new Color(180,255,255));
			card.show(mainPanel	, "a4");
		}

	}
	private class SelectSeatActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			for(int i=1;i<41;i++) {
				if(e.getSource()==seats[i]) {



					if(seat_Check[i]==true)
					{
						seat_Check[i]=false;
						seats[i].setBackground(new Color(206,242,121));
						list_seat_n.remove(i+"");
					}
					else
					{
						if((list_seat.size())<Integer.parseInt(head_Count)) {

							seat_Check[i]=true;
							seats[i].setBackground(new Color(108,192,255));
							list_seat_n.add(i+"");
						}
					}

					if(i<5) {
						if(seat_Check[i]==true) {
							if((list_seat.size())<Integer.parseInt(head_Count))
								list_seat.add("A"+i);
						}
						else
							list_seat.remove("A"+i);
					}
					else if(i<9)
					{
						if(seat_Check[i]==true) {
							if((list_seat.size())<Integer.parseInt(head_Count))
								list_seat.add("B"+i);
						}
						else
							list_seat.remove("B"+i);
					}
					else if(i<13)
					{
						if(seat_Check[i]==true) {
							if((list_seat.size())<Integer.parseInt(head_Count))
								list_seat.add("C"+i);
						}
						else
							list_seat.remove("C"+i);
					}
					else if(i<17)
					{
						if(seat_Check[i]==true)
						{
							if((list_seat.size())<Integer.parseInt(head_Count))
								list_seat.add("D"+i);
						}
						else
							list_seat.remove("D"+i);
					}
					else if(i<21)
					{
						if(seat_Check[i]==true)
						{
							if((list_seat.size())<Integer.parseInt(head_Count))
								list_seat.add("E"+i);
						}
						else
							list_seat.remove("E"+i);
					}
					else if(i<25)
					{
						if(seat_Check[i]==true)
						{
							if((list_seat.size())<Integer.parseInt(head_Count))
								list_seat.add("F"+i);
						}
						else
							list_seat.remove("F"+i);
					}
					else if(i<29)
					{
						if(seat_Check[i]==true)
						{
							if((list_seat.size())<Integer.parseInt(head_Count))
								list_seat.add("G"+i);
						}
						else
							list_seat.remove("G"+i);
					}
					else if(i<33)
					{
						if(seat_Check[i]==true)
						{
							if((list_seat.size())<Integer.parseInt(head_Count))
								list_seat.add("H"+i);
						}
						else
							list_seat.remove("H"+i);
					}
					else if(i<37)
					{
						if(seat_Check[i]==true)
						{
							if((list_seat.size())<Integer.parseInt(head_Count))
								list_seat.add("I"+i);
						}
						else
							list_seat.remove("I"+i);
					}
					else if(i<41)
					{
						if(seat_Check[i]==true)
						{
							if((list_seat.size())<Integer.parseInt(head_Count))
								list_seat.add("J"+i);
						}
						else
							list_seat.remove("J"+i);
					}

				}
			}
		}

	}

	private class SelectDateActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			for(int i=23;i<=31;i++)
				if(e.getSource()==date_Sellect_Button[i]) {
					date="2018-12-"+i+"";
				}			
			card.show(mainPanel	, "a4");
			date_Button.setText(date);
		}

	}




	private class MyMouseListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mousePressed(MouseEvent e) {

		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
	private class SingUpButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {

			try {Statement stmt = conn.createStatement();	
			int age;
			String user_Id,user_Name,user_Password;
			age=Integer.parseInt(user_Age_Field.getText());
			user_Id=user_Id_Field.getText();
			user_Name=user_Name_Field.getText();
			user_Password=user_Password_Field.getText();
			// SQL 문을 작성을 위한  Statement 객체 생성
			stmt.executeUpdate("INSERT INTO customer (name, age ,customer_id, customer_password) VALUES ('" +
					user_Name.trim() + "' ," +
					age + " ,'" +
					user_Id.trim() + "' ,'" +
					user_Password.trim() + "')");


			stmt.close();
			card.show(mainPanel	, "a1");
			signUpClear();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage()+"dd");
				if(sqlex.getMessage().equals("Duplicate entry 'junsu990207' for key 'PRIMARY'")) {
					System.out.println("프라이머리키 애러");
					overlap_Id_Label.setText("중복된 아이디 입니다.");
				}
				else
					card.show(mainPanel	, "a1");
				//sqlex.printStackTrace();
			}catch (java.lang.NumberFormatException ex) {
				overlap_Id_Label.setText("잘못된 입력입니다.");

				//ex.printStackTrace();

			} catch (Exception ex) {
				System.out.println("DB Handling 에러(SAVE 리스너) : " + ex.getMessage());
				//ex.printStackTrace();
			}


		}

	}
	private class LoginCheckListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
			try {Statement stmt = conn.createStatement();	
			boolean id=false,password=false;
			String user_Password;
			user_Id=user_Id_Field2.getText();
			user_Password=user_Password_Field2.getText();
			// SQL 문을 작성을 위한  Statement 객체 생성
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE customer_id='"+user_Id+"'");
		


			if(rs.next()==false) {
				login_check_Label.setText("아이디가 존재하지 않습니다");
			}
			else {

				System.out.println("아이디"+user_Id+rs.getString("customer_id"));
				System.out.println("비번"+user_Password+rs.getString("customer_password"));
				if(user_Password.equals(rs.getString("customer_password")))
				{
					frame.setSize(WIDTH,A4_HEIGHT);
					card.show(mainPanel	, "a4");

					loginClear();    
				}
				else
					login_check_Label.setText("아이디와 비밀번호가 일치하지 않습니다");	    			    			  	

			}
			

			stmt.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage()+"dd");

				sqlex.printStackTrace();
			}catch (java.lang.NumberFormatException ex) {


				ex.printStackTrace();

			} catch (Exception ex) {
				System.out.println("DB Handling 에러(SAVE 리스너) : " + ex.getMessage());
				ex.printStackTrace();
			}


		}

	}
	private void dbConnectionInit() {
		try {
			Class.forName("com.mysql.jdbc.Driver");					// JDBC드라이버를 JVM영역으로 가져오기
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/project", "root", "");	// DB 연결하기

		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("JDBC 드라이버 클래스를 찾을 수 없습니다 : " + cnfe.getMessage());
		}
		catch (Exception ex) {
			System.out.println("DB 연결 에러 : " + ex.getMessage());
		}
	}
	public void seatMake() {
		int x,y,w,h,c;
		x=0;
		y=0;	
		w=100;
		h=70;	
		c=0;
		seats =new JButton[41];
		for(int i=1;i<5;i++)
			seats[i]= new JButton("A"+i);
		for(int i=5;i<8;i++)
			seats[i]= new JButton("B"+(i%4));
		seats[8]= new JButton("B4");
		for(int i=9;i<12;i++)
			seats[i]= new JButton("C"+(i%4));
		seats[12]= new JButton("C4");
		for(int i=13;i<16;i++)
			seats[i]= new JButton("D"+(i%4));
		seats[16]= new JButton("D4");
		for(int i=17;i<20;i++)
			seats[i]= new JButton("E"+(i%4));
		seats[20]= new JButton("E4");
		for(int i=21;i<24;i++)
			seats[i]= new JButton("F"+(i%4));
		seats[24]= new JButton("F4");
		for(int i=25;i<28;i++)
			seats[i]= new JButton("G"+(i%4));
		seats[28]= new JButton("G4");
		for(int i=29;i<32;i++)
			seats[i]= new JButton("H"+(i%4));
		seats[32]= new JButton("H4");
		for(int i=33;i<36;i++)
			seats[i]= new JButton("I"+(i%4));
		seats[36]= new JButton("I4");
		for(int i=37;i<40;i++)
			seats[i]= new JButton("J"+(i%4));
		seats[40]= new JButton("J4");


		for(int i=1;i<41;i++) {
			seats[i].setBounds(x, y, w, h);

			x+=100;
			c++;
			if(c==2)
				x+=70;
			if(i%4==0) {
				c=0;
				x=0;
				y+=70;
			}
		}
		for(int i=1;i<41;i++) {
			//	seats[i].text
		}

		for(int i=1;i<41;i++) {
			seats[i].setBackground(new Color(206,242,121));
			seats[i].addActionListener(new SelectSeatActionListener());
			seat_Select_Panel.add(seats[i]);
		}


	}

	public class Seat{
		public String seat_name;
		public int seat_id;
	}

	public class DisplayButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			// DB에서 가져오는 데이터를 rowObjects의 형태로 저장하고 이들의 리스트를 Printer 또는 Preview로 보내 줌
			ArrayList<RowObjects> rowList = new ArrayList<RowObjects>();	// 행들의 리스트
			RowObjects line;												// 하나의 행
			PrintObject word;												// 하나의 단어
			try {
				Statement stmt = conn.createStatement();					// SQL 문장 만들기 위한 Statement 객체
				ResultSet rs = stmt.executeQuery("SELECT departure_t 출발시간, departure_date 출발일, (SELECT country_name FROM country WHERE country_id = l.starting_id) 출발지,(SELECT country_name FROM country WHERE country_id = l.destination_id) 도착지,\r\n" + 
						"r.seat_id FROM flight NATURAL JOIN reserve r NATURAL JOIN flight_line l NATURAL JOIN customer WHERE customer_id='"+user_Id+"';");
				while(rs.next()) {
					line = new RowObjects();								// 5개의 단어가 1줄
					line.add(new PrintObject(rs.getString("출발지"), 15));
					line.add(new PrintObject(rs.getString("도착지"), 15));
					line.add(new PrintObject(rs.getString("출발일"), 15));
					line.add(new PrintObject(rs.getString("출발시간"),15));
					line.add(new PrintObject(rs.getString("seat_id"), 10));
					rowList.add(line);										// 출력해야 될 전체 리스트를 만듬									
				}
				stmt.close();

				// 각 페이지의 칼럼 헤더를 위해 한 줄 만들음
				line = new RowObjects();									// 5개의 단어가 1줄
				line.add(new PrintObject("출발지", 15));
				line.add(new PrintObject("도착지", 15));
				line.add(new PrintObject("출발일", 15));
				line.add(new PrintObject("출발시간", 15));
				line.add(new PrintObject("seat_id", 10));

				if (e.getSource() == bPrint) {
					Printer prt = new Printer(new PrintObject("내 예약리스트", 20), line, rowList, true);
					prt.print();
				}
				else {
					Preview prv = new Preview(new PrintObject("내 예약리스트", 20), line, rowList, true);
					prv.preview();
				}

			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			} catch (Exception ex) {
				System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
	public class DeleteReserveActionListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String f_id,s_id;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT flight_id, seat_id FROM reserve WHERE reserve_id = SUBSTRING('"+
						reserve_Box.getSelectedItem().toString().trim() +"',1)");		

				rs.next();
				f_id=rs.getString("flight_id") ;s_id=rs.getString("seat_id");

				stmt.executeUpdate("DELETE FROM flight_seat WHERE flight_id = "+f_id+" AND seat_id= "+s_id+";");
				stmt.executeUpdate("DELETE FROM reserve WHERE reserve_id = SUBSTRING('" +	
						reserve_Box.getSelectedItem().toString().trim() + "',1)");

				reserve_Box.removeAllItems();
				//reserve_id[]
				properties();
				stmt.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			} catch (Exception ex) {
				System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
				ex.printStackTrace();

			}
			seatReset();}

	}
	public void properties() {
		try {

			
			Statement stmt = conn.createStatement();					// SQL 문장 만들기 위한 Statement 객체
			ResultSet rs = stmt.executeQuery("SELECT r.reserve_id 예약번호, departure_t 출발시간, departure_date 출발일, (SELECT country_name FROM country WHERE country_id = l.starting_id) 출발지,(SELECT country_name FROM country WHERE country_id = l.destination_id) 도착지,\r\n" + 
					"r.seat_id 좌석번호 FROM flight NATURAL JOIN reserve r NATURAL JOIN flight_line l NATURAL JOIN customer WHERE customer_id='"+user_Id+"';");


			// 각 페이지의 칼럼 헤더를 위해 한 줄 만들음

			//rs.first();
			while(rs.next()) {
				//reserve_id[reserve_count++]=new String(rs.getString("reserve_id"));
				reserve_Box.addItem(rs.getString("예약번호")+" :"+rs.getString("출발지")+", "+rs.getString("도착지")+", "+rs.getString("출발일")+", "+rs.getString("출발시간")+", "+rs.getString("좌석번호"));
			}

			//reserve_Box.addItem(reserve_id);
			//reserve_Box.add
			if(rs.next()==true) {
				reserve_Box.setSelectedIndex(0);
				reserve_count=0;
				rs.close();
			}
			stmt.close();
		} catch (SQLException sqlex) {
			System.out.println("SQL 에러 : " + sqlex.getMessage());
			sqlex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
			ex.printStackTrace();
		}

	}
	public void ChangeMyPassword() {
		try {

			Statement stmt = conn.createStatement();					// SQL 문장 만들기 위한 Statement 객체
			stmt.executeUpdate("UPDATE customer set customer_password = '"+newPassword_Field.getText()+"' "
					+ "WHERE customer_id = '"+user_Id+"';");


			// 각 페이지의 칼럼 헤더를 위해 한 줄 만들음

			Password_Field.setText(newPassword_Field.getText());


			stmt.close();
		} catch (SQLException sqlex) {
			System.out.println("SQL 에러 : " + sqlex.getMessage());
			sqlex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
			ex.printStackTrace();
		}

	}
	public void showMyPassword() {
		try {
			Statement stmt = conn.createStatement();					// SQL 문장 만들기 위한 Statement 객체
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE customer_id='"+user_Id+"';");


			// 각 페이지의 칼럼 헤더를 위해 한 줄 만들음
			rs.next();

			now_Id=rs.getString("customer_id");
			now_Password=rs.getString("customer_password");

			Password_Field.setText(now_Id);
			Id_Field.setText(now_Password);

			stmt.close();
		} catch (SQLException sqlex) {
			System.out.println("SQL 에러 : " + sqlex.getMessage());
			sqlex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
			ex.printStackTrace();
		}

	}
	public void seatReset() {
		for(int i=1;i<41;i++) {
			seat_Check[i]=false;		
			seats[i].setBackground(new Color(206,242,121));
		}
		try { 
			Statement stmt = conn.createStatement();	
			// SQL 문을 작성을 위한  Statement 객체 생성

			ResultSet rs = stmt.executeQuery("SELECT seat_id FROM flight_seat WHERE flight_id="+flight_key+" AND is_full='y';");
			while(rs.next()) {
				seats[rs.getInt("seat_id")].setEnabled(false);	
				seats[rs.getInt("seat_id")].setBackground(new Color(255,90,90));
				System.out.println("예약된 좌석"+rs.getInt("seat_id"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqlex) {
			System.out.println("SQL 에러 : " + sqlex.getMessage());
			sqlex.printStackTrace();
		}

	}
	public static void main(String[] args) {

		Main f=new Main();
		f.go();
		f.dbConnectionInit();
	}

}

