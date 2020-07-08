package app.entity;

import java.io.Serializable;

public class RewardsStats implements Serializable {

    private String reward;
    private Long count;

    public RewardsStats() {
    }

    public RewardsStats(String reward, Long count) {
        this.reward = reward;
        this.count = count;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
