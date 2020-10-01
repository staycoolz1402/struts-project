package com.mpe.common.dashboard;

public class DashboardLinkDetail {

	public static String getLinkDetail(String menu, String type) {
		
		String link = "";
		
		if (menu.equalsIgnoreCase(DashboardMenu.FIXED_ASSET.name()) && type.equalsIgnoreCase(DashboardType.TRADE_IN_APPROVAL.name())) link = "/fixassetTradeIn/approval/detail.do";
		if (menu.equalsIgnoreCase(DashboardMenu.FIXED_ASSET.name()) && (type.equalsIgnoreCase(DashboardType.CANCEL_SALES.name()) || type.equalsIgnoreCase(DashboardType.CANCEL_WO.name()))) link = "/fixasset/cancelSalesWo/detail.do";
		if (menu.equalsIgnoreCase(DashboardMenu.OR.name()) && (type.equalsIgnoreCase(DashboardType.CANCEL_ADD.name()) || type.equalsIgnoreCase(DashboardType.CANCEL_REKLAS.name()))) link = "/or/approvalOrCancel/detail.do";
		if (menu.equalsIgnoreCase(DashboardMenu.OR.name()) && (type.equalsIgnoreCase(DashboardType.EDIT_ADD.name()) || type.equalsIgnoreCase(DashboardType.EDIT_REKLAS.name()))) link = "/or/approvalOrEdit/detail.do";
		if (menu.equalsIgnoreCase(DashboardMenu.OP.name()) && (type.equalsIgnoreCase(DashboardType.CANCEL_ADD.name()) || type.equalsIgnoreCase(DashboardType.CANCEL_REKLAS.name()))) link = "/op/approvalOpCancel/detail.do";
		if (menu.equalsIgnoreCase(DashboardMenu.OP.name()) && (type.equalsIgnoreCase(DashboardType.EDIT_ADD.name()) || type.equalsIgnoreCase(DashboardType.EDIT_REKLAS.name()))) link = "/op/approvalOpEdit/detail.do";
		if (menu.equalsIgnoreCase(DashboardMenu.OP.name()) && (type.equalsIgnoreCase(DashboardType.APPROVAL_REKLAS.name()))) link = "/op/approvalOpReklas/detail.do";
		if (menu.equalsIgnoreCase(DashboardMenu.OP.name()) && (type.equalsIgnoreCase(DashboardType.APPROVAL_CREATE.name()))) link = "/op/approvalOpCreate/detail.do";
		if (menu.equalsIgnoreCase(DashboardMenu.TERMINATION.name()) && type.equalsIgnoreCase(DashboardType.APPROVAL_CANCEL_OTHER_CHARGES.name())) link = "/termination/otherChargesCancelApproval.do";
		if (menu.equalsIgnoreCase(DashboardMenu.TERMINATION.name()) && type.equalsIgnoreCase(DashboardType.APPROVAL_CANCEL.name())) link = "/termination/terminateApproveCancel.do";
		if (menu.equalsIgnoreCase(DashboardMenu.TERMINATION.name()) && type.equalsIgnoreCase(DashboardType.APPROVAL_CANCEL_TERMINATION_PENALTY.name())) link = "/terminationPenalty/penaltyTerminationDeleteDetailApprovalForm.do";
		if (menu.equalsIgnoreCase(DashboardMenu.DEBET_KL.name()) && type.equalsIgnoreCase(DashboardType.APPROVAL_DEBET_KL.name())) link = "/cfTransaction/debetKlApproved.do";
		if (menu.equalsIgnoreCase(DashboardMenu.TERMINATION.name()) && type.equalsIgnoreCase(DashboardType.APPROVAL_UNIT_TITIPAN_NASABAH.name())) link = "/termination/assetForFutureSalesApproval.do";
		if (menu.equalsIgnoreCase(DashboardMenu.REFINANCE_TERMINATION.name()) && type.equalsIgnoreCase(DashboardType.APPROVAL_REFINANCE_TERMINATION.name())) link = "/refinanceTermination/approvalForm.do";
		if (menu.equalsIgnoreCase(DashboardMenu.SMMF_REPORT.name()) && type.equalsIgnoreCase(DashboardType.APPROVAL_RESET_PASSWORD.name())) link = "/employeeRegister/approvalResetPassword.do";
		if (menu.equalsIgnoreCase(DashboardMenu.DEALER.name()) && type.equalsIgnoreCase(DashboardType.APPROVAL_CREATE.name())) link = "/dealer/approvalDealerForm.do";
		
		return link;
		
	}
	
}
