package br.org.mvcpaging;

/// Pager options builder class. Enables a fluent interface for adding options to the pager.
public class PagerOptionsBuilder {

 protected PagerOptions pagerOptions;

 public PagerOptionsBuilder(PagerOptions pagerOptions) {
  this.pagerOptions = pagerOptions;
 }

 /// Set the title for previous page navigation.
 public PagerOptionsBuilder SetPreviousPageTitle(String previousPageTitle) {
  pagerOptions.PreviousPageTitle = previousPageTitle;
  return this;
 }

 /// Set the text for next page navigation.
 public PagerOptionsBuilder SetNextPageText(String nextPageText) {
  pagerOptions.NextPageText = nextPageText;
  return this;
 }

 /// Set the title for next page navigation.
 public PagerOptionsBuilder SetNextPageTitle(String nextPageTitle) {
  pagerOptions.NextPageTitle = nextPageTitle;
  return this;
 }

 /// Set the text for first page navigation.
 public PagerOptionsBuilder SetFirstPageText(String firstPageText) {
  pagerOptions.FirstPageText = firstPageText;
  return this;
 }

 /// Set the title for first page navigation.
 public PagerOptionsBuilder SetFirstPageTitle(String firstPageTitle) {
  pagerOptions.FirstPageTitle = firstPageTitle;
  return this;
 }

 /// Set the text for last page navigation.
 public PagerOptionsBuilder SetLastPageText(String lastPageText) {
  pagerOptions.LastPageText = lastPageText;
  return this;
 }

 /// Set the title for last page navigation.
 public PagerOptionsBuilder SetLastPageTitle(String lastPageTitle) {
  pagerOptions.LastPageTitle = lastPageTitle;
  return this;
 }

 /// Displays both first and last navigation pages.
 public PagerOptionsBuilder DisplayFirstAndLastPage() {
  pagerOptions.DisplayFirstPage = true;
  pagerOptions.DisplayLastPage = true;
  return this;
 }

 /// Displays the first navigation page but not the last.
 public PagerOptionsBuilder DisplayFirstPage() {
  pagerOptions.DisplayFirstPage = true;
  return this;
 }

 /// Displays the last navigation page but not the first.
 public PagerOptionsBuilder DisplayLastPage() {
  pagerOptions.DisplayLastPage = true;
  return this;
 }

 public PagerOptionsBuilder HidePreviousAndNextPage() {
  pagerOptions.HidePreviousAndNextPage = true;
  return this;
 }

 /// Set custom route value parameters for the pager links.
 public PagerOptionsBuilder RouteValues(Object routeValues) {
  return this;
 }
}
