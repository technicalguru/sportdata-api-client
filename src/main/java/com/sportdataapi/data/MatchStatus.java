/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sportdataapi.util.MatchStatusDeserializer;

/**
 * @author ralph
 *
 */
@JsonDeserialize(using=MatchStatusDeserializer.class)
public enum MatchStatus {

	NOT_STARTED     (0,  SimpleMatchStatus.NOT_STARTED, "The event has not started"),
	INPLAY          (1,  SimpleMatchStatus.INPLAY, "The event is inplay"),
	HALF_TIME       (11, SimpleMatchStatus.INPLAY, "The event is in half-time"),
	EXTRA_TIME      (12, SimpleMatchStatus.INPLAY, "The event is in extra time"),
	PENALTIES       (13, SimpleMatchStatus.INPLAY, "The event is in penalties because extra time didn't determinate a winner."),
	BREAK_TIME      (14, SimpleMatchStatus.INPLAY, "Event is in break waiting for extra time or penalties."),
	AWARDING        (15, SimpleMatchStatus.INPLAY, "Awarding of a victory to a contestant because there are no other contestants."),
	UPDATE          (2,  SimpleMatchStatus.INPLAY, "Event will be updated later."),
	ENDED           (3,  SimpleMatchStatus.FINISHED, "Event has ended after 90 minutes."),
	AFTER_PENALTIES (31, SimpleMatchStatus.FINISHED, "Event has ended after penalty shootout."),
	AFTER_EXTRA_TIME(32, SimpleMatchStatus.FINISHED, "The event has finished after extra time."),
	POSTPONED       (4,  SimpleMatchStatus.POSTPONED, "The event has been Postponed."),
	CANCELLED       (5,  SimpleMatchStatus.CANCELLED, "The event has been Cancelled."),
	ABANDONED       (6,  SimpleMatchStatus.ABORTED, "The event has abandoned and will continue at a later time or day."),
	INTERRUPTED     (7,  SimpleMatchStatus.INPLAY, "The event has been interrupted. Can be due to bad weather for example."),
	SUSPENDED       (8,  SimpleMatchStatus.INPLAY, "The event has been suspended."),
	AWARDED         (9,  SimpleMatchStatus.FINISHED, "Winner is beeing decided externally."),
	DELAYED         (10, SimpleMatchStatus.NOT_STARTED, "The event is delayed.");
	
	private int id;
	private String description;
	private SimpleMatchStatus simpleStatus;
	
	/**
	 * Constructor.
	 */
	private MatchStatus(int id, SimpleMatchStatus simpleStatus, String description) {
		this.id           = id;
		this.simpleStatus = simpleStatus;
		this.description  = description;
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the simpleStatus.
	 * @return the simpleStatus
	 */
	public SimpleMatchStatus getSimpleStatus() {
		return simpleStatus;
	}

	/**
	 * Return the match status of the given id.
	 * @param id - ID of the status
	 * @return - the enum value
	 */
	public static MatchStatus withId(int id) {
		for (MatchStatus s : MatchStatus.values()) {
			if (s.getId() == id) return s;
		}
		return null;
	}
	
}
