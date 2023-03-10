package com.company;

public class State extends StateTree {
    private String stateName;
    private String stateCapital;

    public State(String stateName, String stateCapital) {
        this.stateName = stateName;
        this.stateCapital = stateCapital;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setStateCapital(String stateCapital) {
        this.stateCapital = stateCapital;
    }

    public String getStateName() {
        return stateName;
    }

    public String getStateCapital() {
        return stateCapital;
    }

    public int compareTo (State other) {
        return this.stateName.compareTo(other.stateName);
    }


}
