package com.aapsdevelopment.getup.model;

public class Alarm
{
	private long id;

	private String title;

	private long category;

	private long date;

	private long days;

	private long song;

	public Alarm()
	{
		this( 0L, "", 0l, 0l, 0l, 0l );
	}

	public Alarm( long id, String title, long category, long date, long days, long song )
	{
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.date = date;
		this.days = days;
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

	public long getDate()
	{
		return date;
	}

	public void setDate( long date )
	{
		this.date = date;
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
