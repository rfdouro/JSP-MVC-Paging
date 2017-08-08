package br.org.mvcpaging;


public class PagerOptions {

 public String DisplayTemplate;
 public int MaxNrOfPages;
 public boolean AlwaysAddFirstPageNumber;
 public String PageRouteValueKey;
 public String PreviousPageText;
 public String PreviousPageTitle;
 public String NextPageText;
 public String NextPageTitle;
 public String FirstPageText;
 public String FirstPageTitle;
 public String LastPageText;
 public String LastPageTitle;
 private boolean displayFirstAndLastPage;

 public boolean DisplayFirstAndLastPage() {
  return DisplayFirstPage && DisplayLastPage;
 }
 public boolean DisplayFirstPage;
 public boolean DisplayLastPage;
 public boolean HidePreviousAndNextPage;
 public boolean UseItemCountAsPageCount;

 public PagerOptions() {
  DisplayTemplate = Defaults.DisplayTemplate;
  MaxNrOfPages = Defaults.MaxNrOfPages;
  AlwaysAddFirstPageNumber = Defaults.AlwaysAddFirstPageNumber;
  PageRouteValueKey = Defaults.DefaultPageRouteValueKey;
  PreviousPageText = DefaultDefaults.PreviousPageText;
  PreviousPageTitle = DefaultDefaults.PreviousPageTitle;
  NextPageText = DefaultDefaults.NextPageText;
  NextPageTitle = DefaultDefaults.NextPageTitle;
  FirstPageText = DefaultDefaults.FirstPageText;
  FirstPageTitle = DefaultDefaults.FirstPageTitle;
  LastPageText = DefaultDefaults.LastPageText;
  LastPageTitle = DefaultDefaults.LastPageTitle;
  DisplayFirstPage = DefaultDefaults.DisplayFirstPage;
  DisplayLastPage = DefaultDefaults.DisplayLastPage;
  UseItemCountAsPageCount = DefaultDefaults.UseItemCountAsPageCount;
  HidePreviousAndNextPage = DefaultDefaults.HidePreviousAndNextPage;
 }
}
