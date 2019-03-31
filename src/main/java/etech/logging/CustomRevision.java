package etech.logging;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "Revision")
@RevisionEntity(CustomyRevisionListener.class)
public class CustomRevision extends DefaultRevisionEntity implements Serializable {

	private String userName;

	@Column(name = "modified_date")
	@LastModifiedDate
	private LocalDateTime modifiedDate;

	@Column(name = "host")
	private String host;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}