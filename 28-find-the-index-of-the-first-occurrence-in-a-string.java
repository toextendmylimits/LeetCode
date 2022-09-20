//Traverse all the possible starting points of haystack (from 0 to haystack.length() - needle.length()) 
//and see if the following characters in haystack match those of needle.

  public int strStr(String haystack, String needle) {
      for(int i = 0; i <= haystack.length() - needle.length(); i++) {
          int j = 0;
          for(; j < needle.length(); j++) {
              if(haystack.charAt(i + j) != needle.charAt(j)) {
                  break;
              }
          }

          if(j == needle.length()) {
              return i;
          }
      }

      return -1;
  }
