package br.org.mvcpaging;

/**
 *
 * @author rfdouro
 * this interface has a initial point to implements a class 
 * with a method by translate the pagination data to html string
 */
public interface TemplatePaging {
 public String ToHtmlString(PaginationModel model, PagerOptions pagerOptions, String updateTargetId);
}
