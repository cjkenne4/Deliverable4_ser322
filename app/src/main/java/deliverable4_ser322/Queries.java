
package deliverable4_ser322;

import javafx.beans.value.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {
	// Shows Queries
	static VBox vbox = new VBox(10);

	// Choice boxes of Queries
	HBox qLists = new HBox(10);
	ChoiceBox<String> c1 = new ChoiceBox<String>(FXCollections.observableArrayList(" "));
	ChoiceBox<String> c2 = new ChoiceBox<String>(FXCollections.observableArrayList(" "));

	// integer values of each list
	int l1;
	int l2;

	// Text boxes for query support
	static HBox textFields = new HBox(10);
	static TextField t1 = new TextField();
	static TextField t2 = new TextField();
	static TextField t3 = new TextField();
	static TextField t4 = new TextField();

	// The almighty button
	Button run = new Button("run");

	public void addQueries() {
		
		vbox.getChildren().add(qLists);
		vbox.getChildren().add(textFields);

		qLists.getChildren().add(c1);
		qLists.getChildren().add(c2);
		
		// Starts program with athlete list
		try {
			ObservableList<Object> athleteData = getAllFromTable("athlete", TableType.ATHLETE);
			App.tabs.addTableTab("Athlete", athleteData, TableType.ATHLETE, App.stage);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		// ************************** Lists **************************
		String queries[] = { "Show All", "Top 5 Performers", "First Place Winners" }; // TODO
		c1 = new ChoiceBox<String>(FXCollections.observableArrayList(queries));
		c1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue ov, Number value, Number new_value) {

				// removes text fields
				textFields.getChildren().clear();
				vbox.getChildren().set(1, textFields);

				// gets value of first list
				l1 = new_value.intValue();

				// Shows whole tables
				if (l1 == 0) {
					String list[] = { "Athlete", "Competition", "Organization", "Sponsor", "Competitions Sponsored",
							"Athlete Stats" };
					c2 = new ChoiceBox<String>(FXCollections.observableArrayList(list));
					c2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
						public void changed(ObservableValue ov, Number value, Number new_value) {
							l2 = new_value.intValue();
						}
					});
					qLists.getChildren().set(1, c2);
					textFields.getChildren().clear();
					textFields.getChildren().add(run);
					vbox.getChildren().set(1, textFields);
				}

				// Shows Top 5 performers
				if (l1 == 1) {
					String list[] = { "Athlete", "Sponsor" };
					c2 = new ChoiceBox<String>(FXCollections.observableArrayList(list));
					c2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
						public void changed(ObservableValue ov, Number value, Number new_value) {
							l2 = new_value.intValue();
						}
					});
					qLists.getChildren().set(1, c2);
					textFields.getChildren().clear();
					textFields.getChildren().add(run);
					vbox.getChildren().set(1, textFields);
				}

				if (l1 == 2) {
					String list[] = { "Acting", "Basketball", "Coding", "Cycling", "Physics", "Project", "Swimming" };
					c2 = new ChoiceBox<String>(FXCollections.observableArrayList(list));
					c2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
						public void changed(ObservableValue ov, Number value, Number new_value) {
							l2 = new_value.intValue();
						}
					});
					qLists.getChildren().set(1, c2);
					textFields.getChildren().clear();
					textFields.getChildren().add(run);
					vbox.getChildren().set(1, textFields);
				}
			}
		});
		qLists.getChildren().set(0, c1);

		// **************************** EVENTS ********************************
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (l1 == 0) {
					if (l2 == 0) {
						try {
							ObservableList<Object> athleteData = getAllFromTable("athlete", TableType.ATHLETE);
							App.tabs.addTableTab("Athlete", athleteData, TableType.ATHLETE, App.stage);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (l2 == 1) {
						try {
							ObservableList<Object> compData = getAllFromTable("competition", TableType.COMPETITION);
							App.tabs.addTableTab("Competition", compData, TableType.COMPETITION, App.stage);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else if (l2 == 2) {
						try {
							ObservableList<Object> orgData = getAllFromTable("organization", TableType.ORGANIZATION);
							App.tabs.addTableTab("Organization", orgData, TableType.ORGANIZATION, App.stage);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else if (l2 == 3) {
						try {
							ObservableList<Object> sponsorData = getAllFromTable("sponsor", TableType.SPONSOR);
							App.tabs.addTableTab("Sponsor", sponsorData, TableType.SPONSOR, App.stage);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else if (l2 == 4) {
						ObservableList<Object> compSponsorData = null;
						try {
							compSponsorData = getAllFromTable("competitions_sponsored",
									TableType.COMPETITIONS_SPONSORED);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						App.tabs.addTableTab("Competitions_Sponsored", compSponsorData,
								TableType.COMPETITIONS_SPONSORED, App.stage);
					} else if (l2 == 5) {
						ObservableList<Object> athStatData = null;
						try {
							athStatData = getAllFromTable("athlete_stats", TableType.ATHLETE_STATS);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						App.tabs.addTableTab("Athlete_Stats", athStatData, TableType.ATHLETE_STATS, App.stage);
					} else
						System.out.println("Invalid");
				}
			}
		};

		run.setOnAction(event);

	}

	public static Object mapFromResultSet(ResultSet rs, TableType tType) {
		Object nObj = null;
		try {
			nObj = tType.newDbObject(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nObj;
	}

	public static ObservableList<Object> getAllFromTable(String tableName, TableType tType) throws SQLException {
		String Query = "select * " + "from " + tableName;

		return GenericRM.getAttributesFromQuery(Query, rs -> mapFromResultSet(rs, tType));
	}

	public VBox getQbox() {
		return vbox;
	}

}
