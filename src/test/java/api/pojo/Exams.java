package api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Exams {
    private String id;
    private String school;
    private String name;
    private String academicPeriod;
    private GradeLevel gradeLevel;
    private String type;

    public Exams() {
    }

    public Exams(String school, String name, String academicPeriod, GradeLevel gradeLevel, String type) {
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

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EntityField {
        private String id;
        private String tenantId;
        private String name;
        private String code;
        private String type;
        private String hint;
        private String defaultValue;

        public EntityField() {
        }

        public EntityField(String tenantId, String name, String code, String type,
                           String hint, String defaultValue) {
            this.tenantId = tenantId;
            this.name = name;
            this.code = code;
            this.type = type;
            this.hint = hint;
            this.defaultValue = defaultValue;
        }
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
        }
    }
}