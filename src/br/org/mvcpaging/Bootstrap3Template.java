package br.org.mvcpaging;

/**
 *
 * @author rfdouro this template uses Bootstrap 3
 */
public class Bootstrap3Template implements TemplatePaging {

 @Override
 public String ToHtmlString(PaginationModel model, PagerOptions pagerOptions, String updateTargetId) {

  StringBuilder sb = new StringBuilder();
  for (PaginationModel.PaginationLink paginationLink : model.PaginationLinks) {
   if (paginationLink.Active) {
    if (paginationLink.IsCurrent) {
     sb.append("<li class=\"active disabled\"><a>" + paginationLink.DisplayText + "</a></li>");
    } else if (paginationLink.PageIndex == null) {

     sb.append("<li class=\"disabled\"><a>" + paginationLink.DisplayText + "</a></li>");
    } else {
     StringBuilder linkBuilder = new StringBuilder("<li><a");

     //this line is included to load the content in div using jquery
     if (updateTargetId != null) {
      linkBuilder.append(" href=\"\" onclick=\"javascript:$('#" + updateTargetId + "').load('" + paginationLink.Url + "'); return false;\" title=\"" + paginationLink.DisplayTitle + "\">" + paginationLink.DisplayText + "</a></li>");
     }

     //by default, only generates link 
     if (updateTargetId == null) {
      linkBuilder.append(" href=\"" + paginationLink.Url + "\" title=\"" + paginationLink.DisplayTitle + "\">" + paginationLink.DisplayText + "</a></li>");
     }

     sb.append(linkBuilder.toString());
    }
   } else if (!paginationLink.IsSpacer) {
    sb.append("<li class=\"disabled\"><a>" + paginationLink.DisplayText + "</a></li>");
   } else {
    //sb.append("<li class=\"spacer\">" + paginationLink.DisplayText + "</li>");
   }
  }
  return sb.toString();

 }

}
