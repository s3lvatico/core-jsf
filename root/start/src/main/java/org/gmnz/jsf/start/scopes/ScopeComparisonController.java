package org.gmnz.jsf.start.scopes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ScopeComparisonController {

	public String submitData() {
		return "scopeComparison1-2";
	}

}
