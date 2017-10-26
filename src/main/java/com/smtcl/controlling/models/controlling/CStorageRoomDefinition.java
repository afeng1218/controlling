package com.smtcl.controlling.models.controlling;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.*;

/**
 * CStorageRoomDefinition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "c_storage_room_definition", catalog = "controlling", uniqueConstraints = @UniqueConstraint(columnNames = "storage_room_no"))
public class CStorageRoomDefinition implements java.io.Serializable{

	// Fields
	private Integer   storageRoomId;
	private String    storageRoomNo;
	private String    storageRoomDescribe;
	private String    storageRoomState;
	private Timestamp invalidDate;
	private String    couldNet;
	private String    planMethod;
	private String    positionControl;
	private String    storageRoomPosition;
	private String    principalCustodian;
	private Timestamp storageRoomCreateDate;
	private String    creator;
	private Integer   isStereoLibrary;

	/**
	 * default constructor
	 */
	public CStorageRoomDefinition(){

	}

	/**
	 * minimal constructor
	 */
	public CStorageRoomDefinition(Integer storageRoomId, String storageRoomNo){

		this.storageRoomId = storageRoomId;
		this.storageRoomNo = storageRoomNo;
	}

	/**
	 * full constructor
	 */
	public CStorageRoomDefinition(Integer storageRoomId, String storageRoomNo,
	                              String storageRoomDescribe, String storageRoomState,
	                              Timestamp invalidDate, String couldNet, String planMethod,
	                              String positionControl, String storageRoomPosition,
	                              String principalCustodian, Timestamp storageRoomCreateDate,
	                              String creator, Integer isStereoLibrary){

		this.storageRoomId = storageRoomId;
		this.storageRoomNo = storageRoomNo;
		this.storageRoomDescribe = storageRoomDescribe;
		this.storageRoomState = storageRoomState;
		this.invalidDate = invalidDate;
		this.couldNet = couldNet;
		this.planMethod = planMethod;
		this.positionControl = positionControl;
		this.storageRoomPosition = storageRoomPosition;
		this.principalCustodian = principalCustodian;
		this.storageRoomCreateDate = storageRoomCreateDate;
		this.creator = creator;
		this.isStereoLibrary = isStereoLibrary;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "storage_room_id", unique = true, nullable = false)
	public Integer getStorageRoomId(){

		return this.storageRoomId;
	}

	public void setStorageRoomId(Integer storageRoomId){

		this.storageRoomId = storageRoomId;
	}

	@Column(name = "storage_room_no", unique = true, nullable = false, length = 20)
	public String getStorageRoomNo(){

		return this.storageRoomNo;
	}

	public void setStorageRoomNo(String storageRoomNo){

		this.storageRoomNo = storageRoomNo;
	}

	@Column(name = "storage_room_describe", length = 50)
	public String getStorageRoomDescribe(){

		return this.storageRoomDescribe;
	}

	public void setStorageRoomDescribe(String storageRoomDescribe){

		this.storageRoomDescribe = storageRoomDescribe;
	}

	@Column(name = "storage_room_state", length = 10)
	public String getStorageRoomState(){

		return this.storageRoomState;
	}

	public void setStorageRoomState(String storageRoomState){

		this.storageRoomState = storageRoomState;
	}

	@Column(name = "invalid_date", length = 0)
	public Timestamp getInvalidDate(){

		return this.invalidDate;
	}

	public void setInvalidDate(Timestamp invalidDate){

		this.invalidDate = invalidDate;
	}

	@Column(name = "could_net", length = 10)
	public String getCouldNet(){

		return this.couldNet;
	}

	public void setCouldNet(String couldNet){

		this.couldNet = couldNet;
	}

	@Column(name = "plan_method", length = 20)
	public String getPlanMethod(){

		return this.planMethod;
	}

	public void setPlanMethod(String planMethod){

		this.planMethod = planMethod;
	}

	@Column(name = "position_control", length = 10)
	public String getPositionControl(){

		return this.positionControl;
	}

	public void setPositionControl(String positionControl){

		this.positionControl = positionControl;
	}

	@Column(name = "storage_room_position", length = 50)
	public String getStorageRoomPosition(){

		return this.storageRoomPosition;
	}

	public void setStorageRoomPosition(String storageRoomPosition){

		this.storageRoomPosition = storageRoomPosition;
	}

	@Column(name = "principal_custodian", length = 10)
	public String getPrincipalCustodian(){

		return this.principalCustodian;
	}

	public void setPrincipalCustodian(String principalCustodian){

		this.principalCustodian = principalCustodian;
	}

	@Column(name = "storage_room_create_date", length = 0)
	public Timestamp getStorageRoomCreateDate(){

		return this.storageRoomCreateDate;
	}

	public void setStorageRoomCreateDate(Timestamp storageRoomCreateDate){

		this.storageRoomCreateDate = storageRoomCreateDate;
	}

	@Column(name = "creator", length = 20)
	public String getCreator(){

		return this.creator;
	}

	public void setCreator(String creator){

		this.creator = creator;
	}

	@Column(name = "isStereoLibrary")
	public Integer getIsStereoLibrary(){

		return this.isStereoLibrary;
	}

	public void setIsStereoLibrary(Integer isStereoLibrary){

		this.isStereoLibrary = isStereoLibrary;
	}
}