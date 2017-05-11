package util;

import java.security.SecureRandom;
import java.math.BigInteger;

/**
 * ref: http://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string
 * secure, easy, but a little bit more expensive
 * @author erickson
 *
 */
public final class RandomCodeGenerator {
  private SecureRandom random = new SecureRandom();

  /**
   * generate a random code of 6 characters
   * @return a random code of 6 characters
   */
  public String generateCode() {
    return new BigInteger(30, random).toString(32).toUpperCase();
  }
  
}