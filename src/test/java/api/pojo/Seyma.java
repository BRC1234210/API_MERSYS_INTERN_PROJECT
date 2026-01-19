package api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Seyma {
    private String id;
    private String school;
    private String name;
    private String academicPeriod;
    private GradeLevel gradeLevel;
    private String type;

    public Seyma() {
    }
    public Seyma(String school, String name, String academicPeriod, GradeLevel gradeLevel, String type) {
        this.school = school;
        this.name = name;
        this.academicPeriod = academicPeriod;
        this.gradeLevel = gradeLevel;
        this.type = type;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademicPeriod() {
        return academicPeriod;
    }

    public void setAcademicPeriod(String academicPeriod) {
        this.academicPeriod = academicPeriod;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Exams{" +
                "id='" + id + '\'' +
                ", school='" + school + '\'' +
                ", name='" + name + '\'' +
                ", academicPeriod='" + academicPeriod + '\'' +
                ", gradeLevel=" + gradeLevel +
                ", type='" + type + '\'' +
                '}';
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GradeLevel {

        private String id;

        public GradeLevel() {
        }

        public GradeLevel(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "GradeLevel{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }

}

