package com.snowflakemx.dashmetrics

import grails.plugins.springsecurity.Secured


class PublicController {

    def index() {  }

	@Secured(['ROLE_ADMIN'])
	def adminOnly() { render 'admin' }
	 
}
 