
package persistencia;

import entidades.Alumno;
import entidades.Cursada;
import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursadaData {
    private Connection con = null;
    private AlumnoData aluData;
    private MateriaData matData;

    public CursadaData(miConexion conec) {
        this.con = conec.buscarConexion();
        this.aluData = new AlumnoData(conec);
        this.matData = new MateriaData(conec);
    }
    
    //inscribir alumno en materia
    public void guardarCursada(Cursada cursada) {
        String sql = "INSERT INTO cursada (id_alumno, id_materia, nota, asis, cursa) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cursada.getAlumno().getId());
            ps.setInt(2, cursada.getMateria().getId_materia());
            ps.setFloat(3, cursada.getNota());
            ps.setFloat(4, cursada.getAsis());
            ps.setDate(5, java.sql.Date.valueOf(cursada.getCursa()));
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cursada.setId_cursada(rs.getInt(1));
                System.out.println("el alumno se pudo inscribir " + cursada.getId_cursada());
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("error al intentar inscribirse " + ex.getMessage());
        }
    }
    
    //listado de inscripciones
    public List<Cursada> obtenerCursadas() {
        List<Cursada> cursadas = new ArrayList<>();
        String sql = "SELECT * FROM cursada";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cursada c = new Cursada();
                c.setId_cursada(rs.getInt("id_cursada"));
                c.setNota(rs.getFloat("nota"));
                c.setAsis(rs.getFloat("asis"));
                c.setCursa(rs.getDate("cursa").toLocalDate());
                
                // se buscan los alumnos y las materias por el id
                Alumno a = aluData.buscarAlumnoId(rs.getInt("id_alumno"));
                Materia m = matData.buscarMateriaPorId(rs.getInt("id_materia"));
                
                c.setAlumno(a);
                c.setMateria(m);
                
                cursadas.add(c);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("no se pudo obtener la inscripcion " + ex.getMessage());
        }
        return cursadas;
    }
    //listado de materias si el alumno esta cursando
    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT m.id_materia, m.nombre, m.estado FROM materia m JOIN cursada c ON (m.id_materia = c.id_materia) WHERE c.id_alumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia m = new Materia();
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setActivo(rs.getBoolean("estado"));
                materias.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener materias cursadas: " + ex.getMessage());
        }
        return materias;
    }
    //materias q el alumno no esta cursando
    public List<Materia> obtenerMateriasNoCursadas(int idAlumno) {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado = 1 AND id_materia NOT IN (SELECT id_materia FROM cursada WHERE id_alumno = ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia m = new Materia();
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setActivo(rs.getBoolean("estado"));
                materias.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener materias no cursadas: " + ex.getMessage());
        }
        return materias;
    }
    //borrar inscripcion
    public void borrarCursada(int idAlumno, int idMateria) {
        String sql = "DELETE FROM cursada WHERE id_alumno = ? AND id_materia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            
            int exito = ps.executeUpdate();
            if (exito > 0) {
                System.out.println("inscripcion eliminada permanenteente de la base de datos");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("no se pudo borrar " + ex.getMessage());
        }
    }
    //actualizar nota
    public void actualizarNota(int idAlumno, int idMateria, float nota) {
        String sql = "UPDATE cursada SET nota = ? WHERE id_alumno = ? AND id_materia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            
            int exito = ps.executeUpdate();
            if (exito > 0) {
                System.out.println("se actualizo nota");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("no se pudo actualizar " + ex.getMessage());
        }
    }
}
