package api.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private String id;
    private String name;

    public Country() {}

    public String getId() { return id; }
    public void setId(String id) { this.id= id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class State{
        private String stateId;
        private String stateName;
        public State(){}

        public String getStateId() {
            return stateId;
        }

        public void setStateId(String stateId) {
            this.stateId = stateId;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }
    }
}


