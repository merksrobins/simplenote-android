package com.automattic.simplenote.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;

public class Note {
	protected String simperiumKey;
	protected String content;
	protected Calendar creationDate;
	protected Calendar modificationDate;
	protected Vector<String> tags;
	protected Vector<String> systemTags;
	protected boolean deleted;
	protected boolean pinned;
		    
    public Note()
    {
    }

	public String getSimperiumKey() {
		return simperiumKey;
	}

	public void setSimperiumKey(String simperiumKey) {
		this.simperiumKey = simperiumKey;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public Calendar getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Calendar modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Vector<String> getTags() {
		return tags;
	}

	public void setTags(Vector<String> tags) {
		this.tags = tags;
	}

	public Vector<String> getSystemTags() {
		return systemTags;
	}

	public void setSystemTags(Vector<String> systemTags) {
		this.systemTags = systemTags;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isPinned() {
		return pinned;
	}

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}
	
	public static String dateString(Calendar c, boolean useShortFormat)
	{
		int year, month, day;

		String time, date, retVal;
		time = date = "";
		
		Calendar diff = Calendar.getInstance();
		diff.setTimeInMillis(diff.getTimeInMillis() - c.getTimeInMillis());		
				
		year = diff.get(Calendar.YEAR);
		month = diff.get(Calendar.MONTH);
		day = diff.get(Calendar.DAY_OF_MONTH) ;
		
		diff.setTimeInMillis(0); // starting time
		time = DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
		if(	(year == diff.get(Calendar.YEAR)) &&(month == diff.get(Calendar.MONTH))&&(day == diff.get(Calendar.DAY_OF_MONTH)))
		{
			date = "Today";
			if(useShortFormat)
				retVal = time;
			else
				retVal = date +", " + time;
		}
		else if((year == diff.get(Calendar.YEAR)) && (month == diff.get(Calendar.MONTH)) && (day == 1))
		{
				date = "Yesterday";
				if(useShortFormat)
					retVal = date;
				else
					retVal = date + ", " + time;
		}
		else
		{
			date = new SimpleDateFormat("MMM dd", Locale.US).format(c.getTime());
			retVal = date + ", " + time;
		}

		return retVal;
	}
}