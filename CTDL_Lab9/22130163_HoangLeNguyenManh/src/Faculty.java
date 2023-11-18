import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	// trả về course thực hành có nhiều sinh viên đăng ký học nhất.
	public Course getMaxPracticalCourse() {
		Course maxPractical = null;
		for (Course course : courses) {
			if (maxPractical == null) {
				maxPractical = course;
			} else if (maxPractical.getStudent().size() < course.getStudent().size()) {
				maxPractical = course;
			}
		}
		return maxPractical;
	}

	// thống kê danh sách sinh viên theo năm vào học, với key là năm vào học và
	// value là các sinh viên tương ứng.
	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> map = new HashMap();

		for (Course course : courses) {
			for (Student students : course.getStudent()) {
				List<Student> newList = new ArrayList<>();
				int year = students.getYear();
				if (!map.containsKey(year)) {
					newList.add(students);
					map.put(year, newList);
				} else {
					map.get(year).add(students);
				}
			}

		}
		return map;
	}

	// trả về các course theo loại cho trước (type). Các course được sắp xếp giảm
	// dần theo số
	// lượng sinh viên đăng ký học.
	public Set<Course> filterCourses(String type) {
		Set<Course> newSet = new TreeSet<>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				int a1 = o1.getStudent().size();
				int a2 = o2.getStudent().size();
				return a2 - a1;
			}
		});

		for (Course course : courses) {
			if (course.getType() == type) {
				newSet.add(course);
			}
		}
		return newSet;
	}

	public static void main(String[] args) {
		Student s1 = new Student("01", "Hoang Van A", 2000);
		Student s1a = new Student("01a", "Hoang Van Aa", 2000);
		Student s1b = new Student("01b", "Hoang Van Ab", 2000);
		Student s2 = new Student("02", "Hoang Van B", 2001);
		Student s3 = new Student("03", "Hoang Van C", 2004);
		Student s4 = new Student("04", "Hoang Van D", 2003);
		Student s5 = new Student("05", "Hoang Van E", 2002);

		List<Student> ls1 = new ArrayList<>();
		ls1.add(s1);
		ls1.add(s1a);
		ls1.add(s1b);
		ls1.add(s2);
		ls1.add(s3);
		ls1.add(s4);
		ls1.add(s5);

		List<Student> ls3 = new ArrayList<>();
		ls3.add(s1);
		ls3.add(s2);

		List<Student> ls4 = new ArrayList<>();

		ls4.add(s3);
		ls4.add(s4);
		ls4.add(s5);

		Course c1 = new Course(0, "toan a1", "thuchanh", ls1, "thầy Quí");
		Course c2 = new Course(1, "toan a2", "thuchanh", ls3, "thầy Quí");
		Course c3 = new Course(2, "toan a3", "thuchanh", ls4, "thầy Quí");
		Course c4 = new Course(3, "toan xac suat", "lythuyet", ls1, "thầy Nghia");
		Course c5 = new Course(4, "ltnc", "lythuyet", ls1, "cô Nga");

		List<Course> lc2 = new ArrayList<>();
		lc2.add(c1);
		lc2.add(c2);
		lc2.add(c3);
		lc2.add(c4);
		lc2.add(c5);

		Faculty f1 = new Faculty("CNTT", "DHNL", lc2);

		// test getMaxPracticalCourse
		Course c6 = f1.getMaxPracticalCourse();
		System.out.print("get max pratical course: " + "Id:" + c6.getId() + " " + "Title:" + c6.getTitle() + " "
				+ "Type:" + c6.getType() + " " + "số lượng sinh viên:" + c6.getStudent().size() + " " + "Lecturer:"
				+ c6.getLecturer() + "\n");

		// test groupstudentsbyyear
		Map<Integer, List<Student>> newMap = f1.groupStudentsByYear();

		for (Map.Entry<Integer, List<Student>> entry : newMap.entrySet()) {
			System.out.println("\ngroupStudentsByYear " + entry.getKey());

			List<Student> students = entry.getValue();

			Set<Student> printStudents = new HashSet<>();

			for (Student studentss : students) {
				if (!printStudents.contains(studentss)) {
					System.out.print("[" + studentss.getId() + ", Name: " + studentss.getName() + ", Year: "
							+ studentss.getYear() + "]");
					printStudents.add(studentss);
				}
			}
		}

		// test fillterCoures
		System.out.println("\n");
		Set<Course> newSet = f1.filterCourses("thuchanh");
		for (Course course : newSet) {
			System.out.println("filter Courses: " + "Id:" + course.getId() + " " + "title:" + course.getTitle() + " "
					+ "type:" + course.getType() + " " + "Số lượng sinh viên :" + course.getStudent().size());
		}

	}
}