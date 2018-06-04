package research.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassB {

	@XmlAttribute
	private int classBId;
	private String classBName;

	public int getClassBId() {
		return classBId;
	}

	public void setClassBId(int classBId) {
		this.classBId = classBId;
	}

	public String getClassBName() {
		return classBName;
	}

	public void setClassBName(String classBName) {
		this.classBName = classBName;
	}

	@Override
	public String toString() {
		return "ClassB [classBId=" + classBId + ", classBName=" + classBName + "]";
	}

	
}
