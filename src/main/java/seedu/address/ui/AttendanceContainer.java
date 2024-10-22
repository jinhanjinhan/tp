package seedu.address.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.participation.Participation;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class AttendanceContainer extends UiPart<Region> {

    private static final String FXML = "AttendanceContainer.fxml";

    public final List<Participation> participationList;

    @FXML
    private Label week;
    @FXML
    private Label dateRange;

    public AttendanceContainer(List<Participation> participationList) {
        super(FXML);
        this.participationList = participationList;

        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM");

        week.setText("week " + today.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        dateRange.setText(startOfWeek.format(formatter) + " ~ " + endOfWeek.format(formatter));


    }
}