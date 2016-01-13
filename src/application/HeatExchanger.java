package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Heat Exchanger.

 */
public class HeatExchanger {

    private final StringProperty Name;

    /**
     * Default constructor.
     */
    public HeatExchanger() {
        this(null);
    }

    /**
     * Constructor with some initial data.
     */
    public HeatExchanger(String Name) {
        this.Name = new SimpleStringProperty(Name);
    }


    public String getName() {
        return Name.get();
    }

    public void setName(String Name) {
        this.Name.set(Name);
    }

    public StringProperty nameProperty() {
        return Name;
    }

}