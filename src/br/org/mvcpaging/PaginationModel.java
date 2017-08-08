package br.org.mvcpaging;

import java.util.ArrayList;
import java.util.List;

public class PaginationModel {

 public int PageSize;

 public int CurrentPage;

 public int PageCount;

 public int TotalItemCount;

 public List<PaginationLink> PaginationLinks;

 public PaginationModel() {
  PaginationLinks = new ArrayList<PaginationLink>();
 }

 public class PaginationLink {

  public boolean Active;
  public boolean IsCurrent;
  public Integer PageIndex;
  public String DisplayText;
  public String DisplayTitle;
  public String Url;
  public boolean IsSpacer;

 }
}
