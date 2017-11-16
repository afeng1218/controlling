package com.smtcl.controlling.models.controlling;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "c_test_demo", catalog = "controlling")
public class CTest implements java.io.Serializable{
        // Fields
        private Integer id;
        private String name;
        private String dept;
        // Constructors
        /** default constructor */
        public CTest() {
        }

        /** minimal constructor */
        public CTest(String name) {
            this.name = name;
        }

        /** full constructor */
        public CTest(String name, String dept) {
            this.name = name;
            this.dept = dept;
        }

        // Property accessors
        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "id", unique = true)
        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Column(name = "name")
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Column(name = "dept")
        public String getDept() {
            return this.dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

    }
