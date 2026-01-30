package api.pojo;

public class StudentsByGroup {

    private String id;
    private String schoolId;
    private String name;
    private String description;
    private boolean active;
    private boolean publicGroup;
    private boolean showToStudent;

    // ✅ No-Args Constructor (Jackson için şart)
    public StudentsByGroup() {
    }

    // ✅ All-Args Constructor
    public StudentsByGroup(String id,
                           String schoolId,
                           String name,
                           String description,
                           boolean active,
                           boolean publicGroup,
                           boolean showToStudent) {
        this.id = id;
        this.schoolId = schoolId;
        this.name = name;
        this.description = description;
        this.active = active;
        this.publicGroup = publicGroup;
        this.showToStudent = showToStudent;
    }

    // ✅ Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPublicGroup() {
        return publicGroup;
    }

    public void setPublicGroup(boolean publicGroup) {
        this.publicGroup = publicGroup;
    }

    public boolean isShowToStudent() {
        return showToStudent;
    }

    public void setShowToStudent(boolean showToStudent) {
        this.showToStudent = showToStudent;
    }

    @Override
    public String toString() {
        return "StudentGroupRequest{" +
                "id='" + id + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", publicGroup=" + publicGroup +
                ", showToStudent=" + showToStudent +
                '}';
    }
}