package seedu.address.model.tutorial;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.participation.Participation;

/**
 * Represents a Tutorial class for the students
 * Guarantees: details are present and not null, field values are validated
 */
public class Tutorial {

    public static final String MESSAGE_CONSTRAINTS =
            "Subjects should only contain alphanumeric characters only.";
    public static final String VALIDATION_REGEX = "^[a-zA-Z0-9]+$";
    private final String subject;
    private final List<Participation> participationList = new ArrayList<>();

    /**
     * Every field must be present and not null.
     */
    public Tutorial(String subject) {
        requireAllNonNull(subject, participationList);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public List<Participation> getParticipationList() {
        return participationList;
    }

    /**
     * Returns true if both tutorials are of the same subject.
     * This defines a weaker notion of equality between two tutorials.
     */
    public boolean isSameTutorial(Tutorial otherTutorial) {
        if (otherTutorial == this) {
            return true;
        }
        return otherTutorial != null && otherTutorial.getSubject().equalsIgnoreCase(getSubject());
    }
    public static boolean isValidTutorial(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if both tutorials have the same data fields.
     * This defines a stronger notion of equality between two tutorials.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Tutorial)) {
            return false;
        }

        Tutorial otherTutorial = (Tutorial) other;
        return subject.equals(otherTutorial.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject);
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("subject", subject)
                .toString();
    }
}