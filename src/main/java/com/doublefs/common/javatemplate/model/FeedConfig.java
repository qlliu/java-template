package com.doublefs.common.javatemplate.model;

import java.util.Date;

public class FeedConfig {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_config.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_config.config_type
     *
     * @mbg.generated
     */
    private Integer configType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_config.key_code
     *
     * @mbg.generated
     */
    private String keyCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_config.key_name
     *
     * @mbg.generated
     */
    private String keyName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_config.value_code
     *
     * @mbg.generated
     */
    private String valueCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_config.deleted
     *
     * @mbg.generated
     */
    private Byte deleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_config.created_at
     *
     * @mbg.generated
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_config.updated_at
     *
     * @mbg.generated
     */
    private Date updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_config.deleted_at
     *
     * @mbg.generated
     */
    private Date deletedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_config.available
     *
     * @mbg.generated
     */
    private Boolean available;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_config.id
     *
     * @return the value of feed_config.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_config.id
     *
     * @param id the value for feed_config.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_config.config_type
     *
     * @return the value of feed_config.config_type
     *
     * @mbg.generated
     */
    public Integer getConfigType() {
        return configType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_config.config_type
     *
     * @param configType the value for feed_config.config_type
     *
     * @mbg.generated
     */
    public void setConfigType(Integer configType) {
        this.configType = configType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_config.key_code
     *
     * @return the value of feed_config.key_code
     *
     * @mbg.generated
     */
    public String getKeyCode() {
        return keyCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_config.key_code
     *
     * @param keyCode the value for feed_config.key_code
     *
     * @mbg.generated
     */
    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode == null ? null : keyCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_config.key_name
     *
     * @return the value of feed_config.key_name
     *
     * @mbg.generated
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_config.key_name
     *
     * @param keyName the value for feed_config.key_name
     *
     * @mbg.generated
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_config.value_code
     *
     * @return the value of feed_config.value_code
     *
     * @mbg.generated
     */
    public String getValueCode() {
        return valueCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_config.value_code
     *
     * @param valueCode the value for feed_config.value_code
     *
     * @mbg.generated
     */
    public void setValueCode(String valueCode) {
        this.valueCode = valueCode == null ? null : valueCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_config.deleted
     *
     * @return the value of feed_config.deleted
     *
     * @mbg.generated
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_config.deleted
     *
     * @param deleted the value for feed_config.deleted
     *
     * @mbg.generated
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_config.created_at
     *
     * @return the value of feed_config.created_at
     *
     * @mbg.generated
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_config.created_at
     *
     * @param createdAt the value for feed_config.created_at
     *
     * @mbg.generated
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_config.updated_at
     *
     * @return the value of feed_config.updated_at
     *
     * @mbg.generated
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_config.updated_at
     *
     * @param updatedAt the value for feed_config.updated_at
     *
     * @mbg.generated
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_config.deleted_at
     *
     * @return the value of feed_config.deleted_at
     *
     * @mbg.generated
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_config.deleted_at
     *
     * @param deletedAt the value for feed_config.deleted_at
     *
     * @mbg.generated
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_config.available
     *
     * @return the value of feed_config.available
     *
     * @mbg.generated
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_config.available
     *
     * @param available the value for feed_config.available
     *
     * @mbg.generated
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }
}