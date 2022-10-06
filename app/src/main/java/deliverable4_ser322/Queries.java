package deliverable4_ser322;

import javafx.beans.value.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create custom queries that can be executed with ChoiceBox and TextField values.
 */
@SuppressWarnings("rawtypes")
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
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.prefWidthProperty().bind(App.stage.widthProperty().multiply(0.96));
		vbox.prefHeightProperty().bind(App.stage.widthProperty().multiply(0.96));
		qLists.getChildren().add(c1);
		qLists.getChildren().add(c2);

		textFields.setAlignment(Pos.BASELINE_RIGHT);

		// Starts program with athlete list
		try {
			ObservableList<Object> athleteData = getAllFromTable("athlete", TableType.ATHLETE);
			App.tabs.addTableTab("Athlete", athleteData, TableType.ATHLETE, App.stage);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		// ************************** Lists **************************
		String queries[] = { "Show All", "Competition Information", "List of Sponsors and Their Competitions",
				"Athletes That Never Won A Podium", "Category Winners", "Athlete Placement Count", "Top 5 Performers",
				"Top 3 Athletes", "Top 10 Athletes", "Athletes Not Competed", "Delete Athletes Who Haven't Competed",
				"Change Stats of Competition ID 4 to 6" };
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

				// Lists information of a specific competition
				if (l1 == 1) {
					t1.clear();
					t1.setPromptText("CompetitionID");

					String list[] = { "" };
					c2 = new ChoiceBox<String>(FXCollections.observableArrayList(list));
					c2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
						public void changed(ObservableValue ov, Number value, Number new_value) {
							l2 = new_value.intValue();
						}
					});
					qLists.getChildren().set(1, c2);
					textFields.getChildren().clear();
					textFields.getChildren().add(t1);
					textFields.getChildren().add(run);
					vbox.getChildren().set(1, textFields);
				}

				// Lists information of sponsors and the competitions they sponsored
				if (l1 == 2) {
					emptyList();
				}

				// List athletes who have not placed top in a competition (1, 2, or 3)
				if (l1 == 3) {
					emptyList();
				}

				// Lists athletes and what competition categories they won.
				if (l1 == 4) {
					emptyList();
				}

				// Lists athletes who won in a specific place and how many times they won it.
				if (l1 == 5) {
					t1.clear();
					t1.setPromptText("Placement");

					String list[] = { "" };
					c2 = new ChoiceBox<String>(FXCollections.observableArrayList(list));
					c2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
						public void changed(ObservableValue ov, Number value, Number new_value) {
							l2 = new_value.intValue();
						}
					});
					qLists.getChildren().set(1, c2);
					textFields.getChildren().clear();
					textFields.getChildren().add(t1);
					textFields.getChildren().add(run);
					vbox.getChildren().set(1, textFields);
				}

				// Shows Top 5 performers
				if (l1 == 6) {
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

				// Top 3 Athletes
				if (l1 == 7) {
					emptyList();
				}

				// Top 10 Athletes
				if (l1 == 8) {
					emptyList();
				}

				// Show athletes that haven't competed yet
				if (l1 == 9) {
					emptyList();
				}

				// Delete athletes that haven't competed yet
				if (l1 == 10) {
					emptyList();
				}

				// Change competition ID 4 to 6
				if (l1 == 11) {
					emptyList();
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
							App.tabs.createContent().getSelectionModel().selectLast();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					} else if (l2 == 1) {
						try {
							ObservableList<Object> compData = getAllFromTable("competition", TableType.COMPETITION);
							App.tabs.addTableTab("Competition", compData, TableType.COMPETITION, App.stage);
							App.tabs.createContent().getSelectionModel().selectLast();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else if (l2 == 2) {
						try {
							ObservableList<Object> orgData = getAllFromTable("organization", TableType.ORGANIZATION);
							App.tabs.addTableTab("Organization", orgData, TableType.ORGANIZATION, App.stage);
							App.tabs.createContent().getSelectionModel().selectLast();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else if (l2 == 3) {
						try {
							ObservableList<Object> sponsorData = getAllFromTable("sponsor", TableType.SPONSOR);
							App.tabs.addTableTab("Sponsor", sponsorData, TableType.SPONSOR, App.stage);
							App.tabs.createContent().getSelectionModel().selectLast();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else if (l2 == 4) {
						try {
							ObservableList<Object> compSponsorData = getAllFromTable("competitions_sponsored",
									TableType.COMPETITIONS_SPONSORED);
							App.tabs.addTableTab("Competitions_Sponsored", compSponsorData,
									TableType.COMPETITIONS_SPONSORED, App.stage);
							App.tabs.createContent().getSelectionModel().selectLast();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (l2 == 5) {
						try {
							ObservableList<Object> athStatData = getAllFromTable("athlete_stats", TableType.ATHLETE_STATS);
							App.tabs.addTableTab("Athlete_Stats", athStatData, TableType.ATHLETE_STATS, App.stage);
							App.tabs.createContent().getSelectionModel().selectLast();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else
						System.out.println("Invalid");
				}

				// action for information on specific competition
				else if (l1 == 1) {
					String query = "SELECT A.name, C.category, AS1.placement, AS1.winningStatistics"
							+ " FROM Athlete A JOIN Athlete_Stats AS1 ON A.athleteID = AS1.athleteID JOIN Competition C ON AS1.competitionID = C.competitionID"
							+ " WHERE C.competitionID = " + Integer.parseInt(t1.getText())
							+ " ORDER BY AS1.placement ASC;";
					ObservableList<Object> competitionInfo = null;
					try {
						competitionInfo = runQuery("competition_info ", TableType.COMPETITION_INFO, query);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					App.tabs.addTableTab("Competition_Info " + t1.getText(), competitionInfo,
							TableType.COMPETITION_INFO, App.stage);
					App.tabs.createContent().getSelectionModel().selectLast();
				}

				// action for information of sponsors and what competitions they sponsored
				else if (l1 == 2) {
					String query = "SELECT S.sponsorID, S.name, C.competitionID, CS.prize, C.datetime"
							+ " FROM Sponsor S JOIN Competitions_Sponsored CS ON S.sponsorID = CS.sponsorID JOIN Competition C ON CS.competitionID = C.competitionID;";
					ObservableList<Object> sponsorsSponsored = null;
					try {
						sponsorsSponsored = runQuery("Sponsors_Sponsored", TableType.SPONSORS_SPONSORED, query);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					App.tabs.addTableTab("Sponsors_Sponsored", sponsorsSponsored, TableType.SPONSORS_SPONSORED,
							App.stage);
					App.tabs.createContent().getSelectionModel().selectLast();
				}

				// action of athletes who have not placed top in a competition (1, 2, or 3)
				else if (l1 == 3) {
					String query = "SELECT A.name" + " FROM Athlete A" + " WHERE A.athleteID NOT IN ("
							+ "	SELECT A2.athleteID"
							+ "	FROM Athlete A2 JOIN Athlete_Stats AS1 ON A2.athleteID = AS1.athleteID"
							+ "	WHERE AS1.placement > 0);";
					ObservableList<Object> unrankedAthletes = null;
					try {
						unrankedAthletes = runQuery("Unranked_Athletes", TableType.UNRANKED_ATHLETES, query);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					App.tabs.addTableTab("Unranked_Athletes", unrankedAthletes, TableType.UNRANKED_ATHLETES, App.stage);
					App.tabs.createContent().getSelectionModel().selectLast();
				}

				// action of athletes and what competition categories they won
				else if (l1 == 4) {
					String query = "Select A.name, C.category"
							+ " FROM Athlete A JOIN Athlete_Stats AS1 ON A.athleteID = AS1.athleteID JOIN Competition C ON AS1.competitionID = C.competitionID"
							+ " WHERE AS1.placement = 1;";
					ObservableList<Object> categoriesWon = null;
					try {
						categoriesWon = runQuery("Categories_Won", TableType.CATEGORIES_WON, query);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					App.tabs.addTableTab("Categories_Won", categoriesWon, TableType.CATEGORIES_WON, App.stage);
					App.tabs.createContent().getSelectionModel().selectLast();
				}

				// action of athletes who won a specific place and how many times they won it
				else if (l1 == 5) {
					String query = "Select A.name, COUNT(AS1.competitionID) AS count"
							+ " FROM Athlete A JOIN Athlete_Stats AS1 ON A.athleteID = AS1.athleteID"
							+ " WHERE AS1.placement = " + t1.getText() + " GROUP BY A.name;";
					ObservableList<Object> placementNumber = null;
					try {
						placementNumber = runQuery("Placement_Count", TableType.RESULT_SET, query);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					App.tabs.addTableTab("Placement_Count", placementNumber, TableType.RESULT_SET, App.stage);
					App.tabs.createContent().getSelectionModel().selectLast();
				}

				// action for showing top 5 performers
				else if (l1 == 6) {
					if (l2 == 0) {
						String query = "SELECT *" + " FROM Athlete_Stats" + " ORDER BY placement ASC LIMIT 5";
						ObservableList<Object> topAthletes = null;
						try {
							topAthletes = runQuery("Top_5_Performers_Athletes", TableType.ATHLETE_STATS, query);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						App.tabs.addTableTab("Top_5_Performers_Athletes", topAthletes, TableType.ATHLETE_STATS,
								App.stage);
						App.tabs.createContent().getSelectionModel().selectLast();
					} else if (l2 == 1) {
						String query = "SELECT Sponsor.name, Count(Competitions_Sponsored.sponsorID) AS count"
								+ " FROM Competitions_Sponsored" + " JOIN Sponsor"
								+ " ON Sponsor.sponsorID = Competitions_Sponsored.sponsorID"
								+ " GROUP BY Competitions_Sponsored.sponsorID"
								+ " ORDER BY Count(Competitions_Sponsored.sponsorID) DESC LIMIT 5;";
						ObservableList<Object> topSponsors = null;
						try {
							topSponsors = runQuery("Top_5_Performers_Sponsors", TableType.RESULT_SET, query);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						App.tabs.addTableTab("Top_5_Performers_Sponsors", topSponsors, TableType.RESULT_SET, App.stage);
						App.tabs.createContent().getSelectionModel().selectLast();
					}
				}

				// action for top 3 athletes
				else if (l1 == 7) {
					String query = "SELECT Athlete.name, count(Athlete.athleteID) AS count" + " FROM Athlete"
							+ " JOIN Athlete_Stats" + " ON Athlete.athleteID = Athlete_Stats.athleteID"
							+ " WHERE Athlete_Stats.placement = 1" + " GROUP BY Athlete.athleteID\r\n"
							+ " ORDER BY count(Athlete.athleteID) DESC" + " LIMIT 3;";
					ObservableList<Object> topSponsors = null;
					try {
						topSponsors = runQuery("Top_3", TableType.RESULT_SET, query);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					App.tabs.addTableTab("Top_3", topSponsors, TableType.RESULT_SET, App.stage);
					App.tabs.createContent().getSelectionModel().selectLast();
				}

				// action for top 10 athletes
				else if (l1 == 8) {
					String query = "SELECT Athlete.name, Athlete_Stats.placement, Athlete_Stats.winningStatistics"
							+ " FROM Athlete_Stats" + " JOIN Athlete"
							+ " ON Athlete.athleteID = Athlete_Stats.athleteID" + " ORDER BY placement ASC"
							+ " LIMIT 10;";
					ObservableList<Object> topSponsors = null;
					try {
						topSponsors = runQuery("Top_10", TableType.RESULT_SET, query);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					App.tabs.addTableTab("Top_10", topSponsors, TableType.RESULT_SET, App.stage);
					App.tabs.createContent().getSelectionModel().selectLast();
				}

				// Athletes that haven't competed
				else if (l1 == 9) {
					String select = "SELECT * FROM Athlete WHERE athleteID NOT IN "
							+ "(SELECT athleteID FROM Athlete_Stats);";

					ObservableList<Object> athleteData;
					try {
						athleteData = runQuery("Athletes_No_Comps", TableType.ATHLETE, select);
						App.tabs.addTableTab("Athletes_No_Comps", athleteData, TableType.ATHLETE, App.stage);
						App.tabs.createContent().getSelectionModel().selectLast();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

				// Delete athletes that haven't competed
				else if (l1 == 10) {
					String query = "DELETE" 
							+ " FROM Athlete" 
							+ " WHERE athleteID NOT IN (SELECT athleteID"
							+ "        FROM Athlete_Stats);";
					try {
						Crud.executeQuery(query);
						ObservableList<Object> athleteData = getAllFromTable("athlete", TableType.ATHLETE);
						App.tabs.addTableTab("Athlete", athleteData, TableType.ATHLETE, App.stage);
						App.tabs.createContent().getSelectionModel().selectLast();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				// Update stats of competition id 4 to 6
				else if (l1 == 11) {
					String query = "UPDATE Athlete_Stats" 
							+ " SET competitionID = 6"
							+ " WHERE competitionID = 4";
					try {
						Crud.executeQuery(query);
						ObservableList<Object> athStatData = getAllFromTable("athlete_stats", TableType.ATHLETE_STATS);
						App.tabs.addTableTab("Athlete_Stats", athStatData, TableType.ATHLETE_STATS, App.stage);
						App.tabs.createContent().getSelectionModel().selectLast();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		};

		run.setOnAction(event);

	}

	private void emptyList() {
		String list[] = { "" };
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

	public static ObservableList<Object> runQuery(String tableName, TableType tType, String Query) throws SQLException {

		return GenericRM.getAttributesFromQuery(Query, rs -> mapFromResultSet(rs, tType));
	}

	public VBox getQbox() {
		return vbox;
	}

}
