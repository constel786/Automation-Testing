package pojos; //POJO: Plain Old Java Object
public class JsonPlaceHolderPojo {
    //Create private fields
    private Integer userId;
    private String title;
    private Boolean completed;

    //Create default and parameterized constructors
    //Default constructor (right click -> generate):
    public JsonPlaceHolderPojo() {
    }

    //Parametrized constructor (right click -> generate):
    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    //Create setter and getters (right click -> generate)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    //Create toString() method (right click -> generate)
    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}