package me.bixgamer707.choosecountrie.user;

import java.util.UUID;

public class Players {
    private final UUID uuid;
    private String countrie;
    public Players(UUID uuid){
        this.uuid = uuid;
        countrie = "none";
    }
    public UUID getUuid() {
        return uuid;
    }
    public void setCountrie(String countrie){
        this.countrie = countrie;
    }
    public String getCountrie(){
        return countrie;
    }
}
