/*
 * Created on May 12, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.mpe.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ams.mufins.model.UserStream;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ActionListener implements ServletContextListener, HttpSessionListener {
	Log log = LogFactory.getFactory().getInstance(this.getClass());
	private Map<String, UserStream> userstreams = Collections.synchronizedMap(new HashMap<String, UserStream>());
	
	
	//pemakaian WeakHashMap mencegah hard reference ke HttpSession, sehingga mudah di GC kalaupun ada yang error
    private static Map<String, HttpSession> sessions = Collections.synchronizedMap(new WeakHashMap<String, HttpSession>());
    
    public ActionListener() {
		log.warn("Constructor Action listener created");
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		arg0.getServletContext().setAttribute("userstreams",userstreams);
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
    public void sessionCreated(HttpSessionEvent arg0) {
    	try{
            HttpSession session = arg0.getSession();
			UserStream userstream = new UserStream();
			session.setAttribute("userstream",userstream);
			userstreams.put(session.getId(), userstream);
            sessions.put(session.getId(), session);
    	} catch (Exception ex) {
    		log.error("Unhandle Exception", ex);
    	}
    }

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		//pisahkan try catch agar userstreams remove tidak menyebabkan error pada
		try {
			userstreams.remove(session.getId());
		}catch(Exception ex) {
			log.error("Unhandle Exception", ex);
		}
		
		try {
            sessions.remove(session.getId());
		}catch(Exception ex) {
			log.error("Unhandle Exception", ex);
		}
			
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		//Saat context destroyed, ada baiknya setiap map di clear untuk release memory agar bisa di GC
		userstreams.clear();
		sessions.clear();
	}

    public static void sessionInvalidate(String sessionId) {
        try {
            HttpSession session = sessions.get(sessionId);
          //cek jika session null, sebab kadang session tidak ada di map krn sudah di GC
            if(session!=null) session.invalidate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
