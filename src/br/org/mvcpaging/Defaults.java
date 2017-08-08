
package br.org.mvcpaging;

/// The static Defaults class allows you to set Pager defaults for the entire application.
/// Set values at application startup.
public class Defaults {

 public static int MaxNrOfPages = DefaultDefaults.MaxNrOfPages;
 public static String DisplayTemplate = DefaultDefaults.DisplayTemplate;
 public static boolean AlwaysAddFirstPageNumber = DefaultDefaults.AlwaysAddFirstPageNumber;
 public static String DefaultPageRouteValueKey = DefaultDefaults.DefaultPageRouteValueKey;
 public static String PreviousPageText = DefaultDefaults.PreviousPageText;
 public static String PreviousPageTitle = DefaultDefaults.PreviousPageTitle;
 public static String NextPageText = DefaultDefaults.NextPageText;
 public static String NextPageTitle = DefaultDefaults.NextPageTitle;
 public static String FirstPageText = DefaultDefaults.FirstPageText;
 public static String FirstPageTitle = DefaultDefaults.FirstPageTitle;
 public static String LastPageText = DefaultDefaults.LastPageText;
 public static String LastPageTitle = DefaultDefaults.LastPageTitle;
 public static boolean DisplayFirstPage = DefaultDefaults.DisplayFirstPage;
 public static boolean DisplayLastPage = DefaultDefaults.DisplayLastPage;
 public static boolean UseItemCountAsPageCount = DefaultDefaults.UseItemCountAsPageCount;

 public static void Reset() {
  MaxNrOfPages = DefaultDefaults.MaxNrOfPages;
  DisplayTemplate = DefaultDefaults.DisplayTemplate;
  AlwaysAddFirstPageNumber = DefaultDefaults.AlwaysAddFirstPageNumber;
  DefaultPageRouteValueKey = DefaultDefaults.DefaultPageRouteValueKey;
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
 }
}
