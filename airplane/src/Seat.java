
public class Seat {
String seat_name;
int seat_id;
public Seat(String s,int i) {
	seat_name=s;
	seat_id=i;
}
public String getSeat_name() {
	return seat_name;
}
public void setSeat_name(String seat_name) {
	this.seat_name = seat_name;
}
public int getSeat_id() {
	return seat_id;
}
public void setSeat_id(int seat_id) {
	this.seat_id = seat_id;
}


}
