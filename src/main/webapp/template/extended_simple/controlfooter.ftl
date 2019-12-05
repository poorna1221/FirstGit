<#assign hasFieldErrors = parameters.name?? && fieldErrors?? && fieldErrors[parameters.name]??/>
<#if hasFieldErrors>
	<div <#rt/><#if parameters.id??>id="wwgrp_${parameters.id}"<#rt/></#if> class="wwgrp">
	<div <#rt/><#if parameters.id??>id="wwerr_${parameters.id}"<#rt/></#if> class="wwerr">
	<#list fieldErrors[parameters.name] as error>
		<div<#rt/>
		<#if parameters.id??>
		 errorFor="${parameters.id}"<#rt/>
		</#if>
		class="errorMessage">
				 ${error?html}
		</div><#t/>
	</#list>
	</div><#t/>
</#if>