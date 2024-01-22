const LocalStrategy = require('passport-local').Strategy;
const bcrypt = require("bcrypt");


function initialize(connection, passport) {
  const authenticateUser = async (username, password, done) => {
    connection.query('SELECT * FROM test.accounts WHERE username = ?', [username], async function(error, results, fields) {
      if (results?.length > 0) {
        try {
          const verification = await bcrypt.compare(password, results[0].password);
          console.log('user verification', verification)
          if (verification) {
            const user = {
              id: results[0].id,
              username: results[0].username,
              password: results[0].password
            };
            return done(null, user)
          } else {
            return done(null, false, {
              message: "Wrong password"
            })
          }
        } catch (e) {
          console.error(e);
          return done(e);
        }
      } else {
        console.error('User not found', fields, error);
        return done(null, false, {
          message: "User not found"
        });
      }
    })
  }
  passport.use(new LocalStrategy({
    usernameField: 'username',
    passwordField: "password"
  }, authenticateUser));
  passport.serializeUser((user, done) => done(null, user.id));
  passport.deserializeUser((id, done) => connection.query("select * from accounts where id = ?", [id], function(err, results) {
    done(err, results[0]);
  }));

}

module.exports = initialize;
