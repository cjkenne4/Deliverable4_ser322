package deliverable4_ser322.table;

import javafx.beans.property.SimpleStringProperty;

public class CategoriesWon {

    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty category = new SimpleStringProperty();
    
    public CategoriesWon(String name, String category)
    {
        this.name.setValue(name);
        this.category.setValue(category);
    }
    public CategoriesWon(Object... args)
    {
        setName((String) args[0]);
        setCategory((String) args[1]);
    }
    public CategoriesWon(){};

    public String getName() {
        return name.get();
    }

    public void setName(String pName) {
        name.set(pName);
    }

    public SimpleStringProperty getNameProperty()
    {
        return name;
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String pCategory) {
        category.set(pCategory);
    }

    public SimpleStringProperty getCategoryProperty()
    {
        return category;
    }
}
