package com.ams.mufins.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.model.ViewBlockMultiple;
import com.ams.mufins.model.dao.ViewBlockMultipleDAO;

public class TabAction extends Action{
	Logger log = Logger.getLogger(this.getClass());
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		String action = mapping.getParameter();
		if(action.equalsIgnoreCase("TABSET")){
			return tabSet(mapping,form,request,response);
		}else if(action.equalsIgnoreCase("TABCHECK")){
			return tabCheck(mapping,form,request,response);
		}else if(action.equalsIgnoreCase("MULTIPLE")){
			return multiple(mapping,form,request,response);
		}
		return null;
	}
	
	public ActionForward tabSet(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	throws Exception {
		HttpSession session = request.getSession();
		String req = request.getParameter("windowId");
		String[] tab = null;
		if(req!=null){
			tab = req.split("~");
		}
		String windowId = (String)session.getAttribute("windowId");
		if(tab!=null){
			if(windowId==null){
				session.setAttribute("windowId", tab[0]);
			}
		}
		
		return null;
	}	
	
	public ActionForward tabCheck(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	throws Exception {
		try {
			HttpSession session = request.getSession();
			String req = request.getParameter("windowId");
			String[] tab = null;
			if(req!=null){
				tab = req.split("~");
			}
			String windowId = (String)session.getAttribute("windowId");
			if(tab!=null){
				if(windowId!=null){
					if(!windowId.equals(tab[0]) && !windowId.equals("default")){
						List<ViewBlockMultiple> viewBlockMultipleList = (List<ViewBlockMultiple>) session.getAttribute("viewBlockMultipleList");
						if(viewBlockMultipleList==null){
							viewBlockMultipleList = ViewBlockMultipleDAO.getInstance().getSession().createCriteria(ViewBlockMultiple.class).add(Restrictions.eq("Active", Boolean.TRUE)).list();
							session.setAttribute("viewBlockMultipleList", viewBlockMultipleList);
						}
						if(viewBlockMultipleList.size()>0){
							for(ViewBlockMultiple vbm : viewBlockMultipleList){
								if(tab[1].contains(vbm.getViewLink())){
									response.sendError(response.SC_BAD_REQUEST, "multitab");
									break;
								}
							}
						}
					}
				}else{
					session.setAttribute("windowId", tab[0]);
				}
			}
		} catch (Exception e) {
			log.error("error", e);
			throw e;
		}
		return null;
	}
	
	public ActionForward multiple(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	throws Exception {
		return mapping.findForward("multipleTab");
	}
	
}
