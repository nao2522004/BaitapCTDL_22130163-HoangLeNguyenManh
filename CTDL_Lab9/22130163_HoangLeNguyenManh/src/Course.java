import java.util.List;

public class Course {

		private int id;
		private String title;
		private String type;
		private List<Student> student;
		private String lecturer;

		public Course(int id, String title, String type, List<Student> student, String lecturer) {
			super();
			this.id = id;
			this.title = title;
			this.type = type;
			this.student = student;
			this.lecturer = lecturer;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<Student> getStudent() {
			return student;
		}

		public void setStudent(List<Student> student) {
			this.student = student;
		}

		public String getLecturer() {
			return lecturer;
		}

		public void setLecturer(String lecturer) {
			this.lecturer = lecturer;
		}

	
}
