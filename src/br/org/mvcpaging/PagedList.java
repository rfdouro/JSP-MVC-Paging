package br.org.mvcpaging;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author romulo.douro
 * @param <E>
 *
 * this is a typed class extended of ArrayList class that generates a sublist of
 * a original list others implementations are possible
 *
 */
public class PagedList<E> extends ArrayList<E> {

 public Integer totalCount = null;
 public int PageCount;
 public int TotalItemCount;
 public int PageIndex;

 public int getPageIndex() {
  return PageIndex;
 }
 private int pageNumber;

 public int getPageNumber() {
  return this.pageNumber + 1;
 }
 public int PageSize = 2;

 public int getTamanhoPagina() {
  return this.PageSize;
 }
 public boolean HasPreviousPage;
 public boolean HasNextPage;
 public boolean IsFirstPage;
 public boolean IsLastPage;
 public int ItemStart;
 public int ItemEnd;

 public PagedList() {

 }

 public PagedList(List<E> source) {
  this(source, 0, 1);
 }

 public Integer getTotalCount() {
  return totalCount;
 }

 public int getPageCount() {
  return PageCount;
 }

 public int getTotalItemCount() {
  return TotalItemCount;
 }

 public int getPageSize() {
  return PageSize;
 }

 public boolean isHasPreviousPage() {
  return HasPreviousPage;
 }

 public boolean isHasNextPage() {
  return HasNextPage;
 }

 public boolean isIsFirstPage() {
  return IsFirstPage;
 }

 public boolean isIsLastPage() {
  return IsLastPage;
 }

 public int getItemStart() {
  return ItemStart;
 }

 public int getItemEnd() {
  return ItemEnd;
 }
 
 

 public PagedList(List<E> source, int index, int pageSize) {
  if (index < 0) {
   throw new RuntimeException("index Value can not be below 0.");
  }
  /*if (pageSize < 1) {
   throw new RuntimeException("pageSize Value can not be less than 1.");
  }*/

  if (source == null) {
   source = new ArrayList<E>();
  }

  int realTotalCount = source.size();

  //PageSize = pageSize;
  //PageIndex = index;
  TotalItemCount = totalCount != null ? totalCount : realTotalCount;
  PageSize = (pageSize == 0) ? TotalItemCount : pageSize;
  PageIndex = (pageSize == 0) ? 0 : index;
  PageCount = TotalItemCount > 0 ? (int) Math.ceil(TotalItemCount / (double) PageSize) : 0;

  HasPreviousPage = (PageIndex > 0);
  HasNextPage = (PageIndex < (PageCount - 1));
  IsFirstPage = (PageIndex <= 0);
  IsLastPage = (PageIndex >= (PageCount - 1));

  ItemStart = PageIndex * PageSize + 1;
  ItemEnd = Math.min(PageIndex * PageSize + PageSize, TotalItemCount);

  if (TotalItemCount <= 0) {
   return;
  }

  List<E> aux = new ArrayList<>();
  aux.addAll(source);
  super.clear();
  if (realTotalCount != TotalItemCount) {
   super.addAll(aux.subList(0, 0));
  } else {
   int a = PageIndex * PageSize;
   int b = (PageIndex + 1) * PageSize;
   if (b >= TotalItemCount) {
    b = realTotalCount;
   }
   List xx = aux.subList(a, b);
   super.addAll(xx);
   //super.addAll(aux.subList(PageIndex * PageSize, PageIndex + 1 * PageSize));
  }
 }

}
