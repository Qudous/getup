package com.aapsdevelopment.getup.model;

public class Alarm
{
	private long id;

	private String title;

	private long category;

	private int hour;

	private int minute;

	private long days;

	private long song;

	public Alarm()
	{
		this( 0L, "", 0, 0, 0l, 0l, 0l );
	}

	public Alarm( long id, String title, int hour, int minute, long days, long category, long song )
	{
		super();
		this.id = id;
		this.title = title;
		this.hour = hour;
		this.minute = minute;
		this.days = days;
		this.category = category;
		this.song = song;
	}

	public long getId()
	{
		return id;
	}

	public void setId( long id )
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle( String title )
	{
		this.title = title;
	}

	public long getCategory()
	{
		return category;
	}

	public void setCategory( long category )
	{
		this.category = category;
	}

	public int getHour()
	{
		return hour;
	}

	public void setHour( int hour )
	{
		this.hour = hour;
	}

	public int getMinute()
	{
		return minute;
	}

	public void setMinute( int minute )
	{
		this.minute = minute;
	}

	public long getDays()
	{
		return days;
	}

	public void setDays( long days )
	{
		this.days = days;
	}

	public long getSong()
	{
		return song;
	}

	public void setSong( long song )
	{
		this.song = song;
	}
}
