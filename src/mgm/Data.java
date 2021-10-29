
package mgm;


public class Data {
    
    public String ind;
    public String studentRollNumber;
    public String studentName;
    public String department;
    public String address;
    public String phone;
    public String attendancePercentage;
    public String year;

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(String studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(String attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    } 
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    
    
    public Data() {        
    }
    
    public Data(String ind, String studentRollNumber, String studentName, String department, String address, String phone, String attendancePercentage , String year) {
        this.ind = ind;
        this.studentRollNumber = studentRollNumber;
        this.studentName = studentName;
        this.department = department;
        this.address = address;
        this.phone = phone;
        this.attendancePercentage = attendancePercentage;
        this.year = year;
    }
    
    
}
