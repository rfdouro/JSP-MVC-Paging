package br.org.mvcpaging;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author romulo.douro this class implements a tag support by using in a java
 * web application (based in jsp/servlet technologies)
 */
public class Pager extends SimpleTagSupport {

 private PagedList lista;

 public void setLista(PagedList lista) {
  this.lista = lista;
  this.totalItemCount = this.lista.TotalItemCount;
  this.currentPage = this.lista.PageIndex;
 }

 private JspWriter htmlHelper;
 private int pageSize;
 private int currentPage;
 private int totalItemCount;
 protected PagerOptions pagerOptions;
 private String routeOptions;
 private String requestMapping;
 private String updateTargetId;
 private String classTemplate;
 private Integer maxNrOfPages;

 public void setPageSize(int pageSize) {
  this.pageSize = pageSize;
 }

 public void setCurrentPage(int currentPage) {
  this.currentPage = currentPage;
 }

 public void setTotalItemCount(int totalItemCount) {
  this.totalItemCount = totalItemCount;
 }

 public void setRouteOptions(String v) {
  this.routeOptions = v;
 }

 public void setRequestMapping(String v) {
  this.requestMapping = v;
 }

 public void setUpdateTargetId(String v) {
  this.updateTargetId = v;
 }

 public Pager() {
  this.pagerOptions = new PagerOptions();
 }

 public void setDisplayFirstPage(boolean v) {
  if (this.pagerOptions != null) {
   this.pagerOptions.DisplayFirstPage = v;
  }
 }

 public void setDisplayLastPage(boolean v) {
  if (this.pagerOptions != null) {
   this.pagerOptions.DisplayLastPage = v;
  }
 }

 public void setFirstPageText(String text) {
  if (this.pagerOptions != null) {
   this.pagerOptions.FirstPageText = text;
  }
 }

 public void setFirstPageTitle(String text) {
  if (this.pagerOptions != null) {
   this.pagerOptions.FirstPageTitle = text;
  }
 }

 public void setLastPageText(String text) {
  if (this.pagerOptions != null) {
   this.pagerOptions.LastPageText = text;
  }
 }

 public void setLastPageTitle(String text) {
  if (this.pagerOptions != null) {
   this.pagerOptions.LastPageTitle = text;
  }
 }

 public void setPreviousPageText(String text) {
  if (this.pagerOptions != null) {
   this.pagerOptions.PreviousPageText = text;
  }
 }

 public void setPreviousPageTitle(String text) {
  if (this.pagerOptions != null) {
   this.pagerOptions.PreviousPageTitle = text;
  }
 }

 public void setNextPageText(String text) {
  if (this.pagerOptions != null) {
   this.pagerOptions.NextPageText = text;
  }
 }

 public void setNextPageTitle(String text) {
  if (this.pagerOptions != null) {
   this.pagerOptions.NextPageTitle = text;
  }
 }

 public void setClassTemplate(String classTemplate) {
  this.classTemplate = classTemplate;
 }

 public void setMaxNrOfPages(int maxNrOfPages) {
  this.maxNrOfPages = maxNrOfPages;
 }

 public Pager(int pageSize, int currentPage, int totalItemCount) {
  this.pageSize = pageSize;
  this.currentPage = currentPage;
  this.totalItemCount = totalItemCount;
  this.pagerOptions = new PagerOptions();
 }

 public void doTag()
         throws JspException, IOException {
  htmlHelper = getJspContext().getOut();
  if (lista != null) {
   if (this.classTemplate != null && !this.classTemplate.equals("")) {
    try {
     Class c = Class.forName(classTemplate);
     if (c != null) {
      TemplatePaging tp = (TemplatePaging) c.newInstance();
      if (tp instanceof TemplatePaging) {
       PaginationModel model = BuildPaginationModel();
       htmlHelper.print(tp.ToHtmlString(model, pagerOptions, updateTargetId));
      } else {
       htmlHelper.print(this.ToHtmlString());
      }
     } else {
      htmlHelper.print(this.ToHtmlString());
     }
    } catch (Exception ex) {
     htmlHelper.print(this.ToHtmlString());
    }
   } else {
    htmlHelper.print(this.ToHtmlString());
   }
  } else {
   htmlHelper.print("...............");
  }
 }

 protected String GeneratePageUrl(int pageNumber) {
  String ret = "?pagina=" + pageNumber;
  if (this.requestMapping != null) {
   ret = this.requestMapping + ret;
  }

  if (this.routeOptions != null) {
   ret += this.routeOptions;
  }
  return ret;
 }

 public PaginationModel BuildPaginationModel() {
  int pageCount;
  if (this.pagerOptions.UseItemCountAsPageCount) {
   pageCount = this.totalItemCount;
   this.totalItemCount = pageCount * this.pageSize;
  } else {
   pageCount = (int) Math.ceil(totalItemCount / (double) pageSize);
  }

  PaginationModel model = new PaginationModel();
  model.PageSize = pageSize;
  model.CurrentPage = currentPage;
  model.TotalItemCount = totalItemCount;
  model.PageCount = pageCount;

  PaginationModel.PaginationLink plink;

  // First page
  if (this.pagerOptions.DisplayFirstPage) {
   plink = model.new PaginationLink();
   plink.Active = currentPage >= 1;
   plink.DisplayText = this.pagerOptions.FirstPageText;
   plink.DisplayTitle = this.pagerOptions.FirstPageTitle;
   plink.PageIndex = 1;
   plink.Url = GeneratePageUrl(1);
   model.PaginationLinks.add(plink);
  }

  // Previous page
  if (!this.pagerOptions.HidePreviousAndNextPage) {
   String previousPageText = this.pagerOptions.PreviousPageText;
   plink = model.new PaginationLink();
   if (currentPage >= 1) {
    plink.Active = true;
    plink.DisplayText = previousPageText;
    plink.DisplayTitle = this.pagerOptions.PreviousPageTitle;
    plink.PageIndex = currentPage - 1;
    plink.Url = GeneratePageUrl(currentPage);
   } else {
    plink.Active = false;
    plink.DisplayText = previousPageText;
   }
   model.PaginationLinks.add(plink);
  }

  int start = 1;
  int end = pageCount;
  int nrOfPagesToDisplay = (this.maxNrOfPages == null) ? this.pagerOptions.MaxNrOfPages : this.maxNrOfPages;

  if (pageCount > nrOfPagesToDisplay) {
   int middle = (int) Math.ceil(((double) nrOfPagesToDisplay) / 2.0) - 1;
   int below = (currentPage - middle);
   int above = (currentPage + middle);

   if (below < 2) {
    above = nrOfPagesToDisplay;
    below = 1;
   } else if (above > (pageCount - 2)) {
    above = pageCount;
    below = (pageCount - nrOfPagesToDisplay + 1);
   }

   start = below;
   end = above;
  }

  /*
  //código original
  if (start > 1) {
   plink = model.new PaginationLink();
   plink.Active = true;
   plink.PageIndex = 1;
   plink.DisplayText = "1";
   plink.Url = GeneratePageUrl(1);
   model.PaginationLinks.add(plink);
   if (start > 3) {
    plink = model.new PaginationLink();
    plink.Active = true;
    plink.PageIndex = 2;
    plink.DisplayText = "2";
    plink.Url = GeneratePageUrl(2);
    model.PaginationLinks.add(plink);
   }
   if (start > 2) {
    plink = model.new PaginationLink();
    plink.Active = false;
    plink.DisplayText = "...";
    plink.IsSpacer = true;
    model.PaginationLinks.add(plink);
   }
  }*/
  
  //variáveis auxiliares
  int ant = (currentPage + 1) - (nrOfPagesToDisplay / 2);
  int dep = (currentPage + 1) + (nrOfPagesToDisplay / 2);

  if (currentPage == pageCount - 1) {
   ant--;
  }

  if (currentPage == 0) {
   dep++;
  }

  //for (int i = start; i <= end; i++) {
  for (int i = 1; i <= pageCount; i++) {
   plink = model.new PaginationLink();
   plink.Active = true;
   plink.PageIndex = i;
   plink.DisplayText = "" + i;
   plink.DisplayTitle = "" + i;
   if (i == currentPage + 1 || (currentPage <= 0 && i == 1)) {
    plink.IsCurrent = true;
   } else {
    plink.Url = GeneratePageUrl(i);
   }
   if (i >= ant && i <= dep) {
    model.PaginationLinks.add(plink);
   }
  }

  /*
  //código original
  if (end < pageCount) {
   if (end < pageCount) {
    plink = model.new PaginationLink();
    plink.Active = false;
    plink.DisplayText = "...";
    plink.IsSpacer = true;
    model.PaginationLinks.add(plink);
   }
   if (end < pageCount - 2) {
    plink = model.new PaginationLink();
    plink.Active = true;
    plink.PageIndex = pageCount;
    plink.DisplayText = "" + pageCount;
    plink.DisplayTitle = "" + pageCount;
    plink.Url = GeneratePageUrl(pageCount);
    model.PaginationLinks.add(plink);
   }
  }*/
  // Next page
  if (!this.pagerOptions.HidePreviousAndNextPage) {
   String nextPageText = this.pagerOptions.NextPageText;
   String nextPageTitle = this.pagerOptions.NextPageTitle;
   if (currentPage < pageCount - 1) {
    plink = model.new PaginationLink();
    plink.Active = true;
    plink.PageIndex = currentPage + 1;
    plink.DisplayText = nextPageText;
    plink.DisplayTitle = this.pagerOptions.NextPageTitle;
    plink.Url = GeneratePageUrl(currentPage + 2);
    model.PaginationLinks.add(plink);
   } else {
    plink = model.new PaginationLink();
    plink.Active = false;
    plink.DisplayText = nextPageText;
    plink.DisplayTitle = nextPageTitle;
    model.PaginationLinks.add(plink);
   }
  }

  // Last page
  if (this.pagerOptions.DisplayLastPage) {
   plink = model.new PaginationLink();
   plink.Active = currentPage < pageCount - 1;
   plink.PageIndex = pageCount;
   plink.DisplayText = this.pagerOptions.LastPageText;
   plink.DisplayTitle = this.pagerOptions.LastPageTitle;
   plink.Url = GeneratePageUrl(pageCount);
   model.PaginationLinks.add(plink);
  }

  return model;
 }

 public String ToHtmlString() {

  PaginationModel model = BuildPaginationModel();

  StringBuilder sb = new StringBuilder();
  for (PaginationModel.PaginationLink paginationLink : model.PaginationLinks) {
   if (paginationLink.Active) {
    if (paginationLink.IsCurrent) {
     sb.append("<span class=\"current\">&nbsp;" + paginationLink.DisplayText + "&nbsp;</span>");
    } else if (paginationLink.PageIndex == null) {
     sb.append("<span>&nbsp;" + paginationLink.DisplayText + "&nbsp;</span>");
    } else {
     StringBuilder linkBuilder = new StringBuilder("<a");

     //this line is included to load the content in div using jquery
     if (updateTargetId != null) {
      linkBuilder.append(" href=\"\" onclick=\"javascript:$('#" + updateTargetId + "').load('" + paginationLink.Url + "'); return false;\" title=\"" + paginationLink.DisplayTitle + "\">&nbsp;" + paginationLink.DisplayText + "&nbsp;</a>");
     }

     //by default, only generates link 
     if (updateTargetId == null) {
      linkBuilder.append(" href=\"" + paginationLink.Url + "\" title=\"" + paginationLink.DisplayTitle + "\">&nbsp;" + paginationLink.DisplayText + "&nbsp;</a>");
     }

     sb.append(linkBuilder.toString());
    }
   } else if (!paginationLink.IsSpacer) {
    sb.append("<span class=\"disabled\">&nbsp;" + paginationLink.DisplayText + "&nbsp;</span>");
   } else {
    //sb.append("<span class=\"spacer\">" + paginationLink.DisplayText + "</span>");
   }
  }
  return sb.toString();

 }
}
