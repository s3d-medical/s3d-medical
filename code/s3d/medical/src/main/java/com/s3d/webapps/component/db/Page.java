package com.s3d.webapps.component.db;

import java.util.ArrayList;
import java.util.List;

public class Page{
  public static int DEFAULT_PAGESIZE = 15;

  public static int DEFAULT_PAGING_LIST_SIZE = 10;
  private List list;
  private int pageno;
  private int rowsize;
  private int total;
  private int totalrows;
  private int start;
  private int end;
  private String orderby;
  private boolean orderReserve;
  private ArrayList pagingList;
  private int pagingListSize;
  private int startPagingNo;
  private int endPagingNo;
  private boolean ascending;

  public Page()
  {
    this.list = new ArrayList();
    this.pagingList = new ArrayList();
  }

  public static Page getEmptyPage() {
    Page page = new Page();
    page.setRowsize(DEFAULT_PAGESIZE);
    page.setList(new ArrayList());
    page.setPagingList(new ArrayList());
    page.setTotal(1);
    page.setPageno(1);

    return page;
  }

  public void excecute()
  {
    if (this.pageno <= 0)
      this.pageno = 1;
    if (this.rowsize <= 0)
      this.rowsize = DEFAULT_PAGESIZE;
    int start = 1;

    if (this.totalrows <= (this.pageno - 1) * this.rowsize) {
      if (this.totalrows % this.rowsize == 0)
        this.pageno = (this.totalrows / this.rowsize);
      else {
        this.pageno = (this.totalrows / this.rowsize + 1);
      }
    }
    if (this.pageno <= 0)
      this.pageno = 1;
    start = this.rowsize * (this.pageno - 1);
    int totalpage = 1;

    if (this.totalrows % this.rowsize == 0)
      totalpage = this.totalrows / this.rowsize;
    else {
      totalpage = this.totalrows / this.rowsize + 1;
    }
    this.total = totalpage;
    this.start = start;

    this.end = (start + this.rowsize - 1);
    if (this.end >= this.totalrows) {
      this.end = (this.totalrows - 1);
    }

    calPagingList();
  }

  public void calPagingList()
  {
    if (this.pagingListSize == 0)
    {
      if (this.total < 10)
        this.endPagingNo = this.total;
      else
        this.endPagingNo = 10;
    }
    else {
      int pagenoSize = this.pageno / this.pagingListSize;
      if (this.pageno % this.pagingListSize > 0)
        this.startPagingNo = (pagenoSize * this.pagingListSize);
      else {
        this.startPagingNo = ((pagenoSize - 1) * this.pagingListSize);
      }

      this.startPagingNo += 1;
      this.endPagingNo = (this.startPagingNo + this.pagingListSize - 1);
      if (this.endPagingNo > this.total) {
        this.endPagingNo = this.total;
      }
    }
    this.pagingList.clear();
    for (int i = this.startPagingNo; i <= this.endPagingNo; i++)
      this.pagingList.add(new Integer(i));
  }

  public boolean isHasNextPage()
  {
    return this.pageno < this.total;
  }

  public boolean isHasPrePage()
  {
    return this.pageno > 1;
  }

  public boolean isHasNextPagingList()
  {
    return this.endPagingNo < getTotal();
  }

  public boolean isHasPrePagingList()
  {
    return (this.pagingListSize > 0) && (this.pageno > this.pagingListSize);
  }

  public int getTotalrows()
  {
    return this.totalrows;
  }

  public void setTotalrows(int totalrows)
  {
    this.totalrows = totalrows;
  }

  public List getList()
  {
    return this.list;
  }

  public int getPageno()
  {
    return this.pageno;
  }

  public int getRowsize()
  {
    return this.rowsize;
  }

  public int getTotal()
  {
    return this.total;
  }

  public void setList(List list)
  {
    this.list = list;
  }

  public void setPageno(int i)
  {
    this.pageno = i;
  }

  public void setRowsize(int i)
  {
    this.rowsize = i;
  }

  public void setTotal(int i)
  {
    this.total = i;
  }

  public int getStart()
  {
    return this.start;
  }

  public void setStart(int start)
  {
    this.start = start;
  }

  public String getOrderby()
  {
    return this.orderby;
  }

  public void setOrderby(String orderby)
  {
    this.orderby = orderby;
  }

  public boolean isOrderReserve()
  {
    return this.orderReserve;
  }

  public void setOrderReserve(boolean orderReserve)
  {
    this.orderReserve = orderReserve;
  }

  public ArrayList getPagingList()
  {
    return this.pagingList;
  }

  public void setPagingList(ArrayList pagingList)
  {
    this.pagingList = pagingList;
  }

  public int getPagingListSize()
  {
    return this.pagingListSize;
  }

  public void setPagingListSize(int pagingListSize)
  {
    this.pagingListSize = pagingListSize;
    calPagingList();
  }

  public int getEnd()
  {
    return this.end;
  }

  public void setEnd(int end)
  {
    this.end = end;
  }

  public int getEndPagingNo()
  {
    return this.endPagingNo;
  }

  public int getStartPagingNo()
  {
    return this.startPagingNo;
  }

  public boolean isAscending() {
    return this.ascending;
  }

  public void setAscending(boolean ascending) {
    this.ascending = ascending;
  }
}