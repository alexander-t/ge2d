package se.tarlinder.ge2d;

public abstract class Component {

    private Entity owningEntity;

    // Empty behavior by default
    public void start() {
    }

    void setOwner(Entity owningEntity) {
        this.owningEntity = owningEntity;
    }

    public Entity getOwner() {
        return owningEntity;
    }

    public abstract void update();
}
